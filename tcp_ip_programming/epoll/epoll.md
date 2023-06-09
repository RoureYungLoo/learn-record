```cpp
int epoll_create(int size); 
int epoll_ctl(int epfd, int op, int fd, struct epoll_event *event); 
int epoll_wait(int epfd, struct epoll_event *events,int maxevents, int timeout);
```

1. 调用 epoll_create 建立一个 epoll 对象（在epoll文件系统中给这个句柄分配资源）；
2. 调用 epoll_ctl 向 epoll 对象中添加多个连接的套接字；
3. 调用 epoll_wait 收集发生事件的连接。

```cpp
struct eventpoll {
  ...
  /*红黑树的根节点，这棵树中存储着所有添加到epoll中的事件，
  也就是这个epoll监控的事件*/
  struct rb_root rbr;
  /*双向链表rdllist保存着将要通过epoll_wait返回给用户的、满足条件的事件*/
  struct list_head rdllist;
  ...
};
```

```cpp
struct epitem {
  ...
  //红黑树节点
  struct rb_node rbn;
  //双向链表节点
  struct list_head rdllink;
  //事件句柄等信息
  struct epoll_filefd ffd;
  //指向其所属的eventepoll对象
  struct eventpoll *ep;
  //期待的事件类型
  struct epoll_event event;
  ...
}; // 这里包含每一个事件对应着的信息。
```

![image-20230609113426341](/home/ruoyang/.config/Typora/typora-user-images/image-20230609113426341.png)

【总结】：

一颗红黑树，一张准备就绪句柄链表，少量的内核cache，就帮我们解决了大并发下的socket处理问题。

- 执行 epoll_create() 时，创建了红黑树和就绪链表；
- 执行 epoll_ctl() 时，如果增加 socket 句柄，则检查在红黑树中是否存在，存在立即返回，不存在则添加到树干上，然后向内核注册回调函数，用于当中断事件来临时向准备就绪链表中插入数据；
- 执行 epoll_wait() 时立刻返回准备就绪链表里的数据即可。

![image-20230609113610207](/home/ruoyang/.config/Typora/typora-user-images/image-20230609113610207.png)

两种模式

epoll 的两种触发模式

epoll有EPOLLLT和EPOLLET两种触发模式，LT是默认的模式，ET是“高速”模式。

- LT（水平触发）模式下，只要这个文件描述符还有数据可读，每次 epoll_wait都会返回它的事件，提醒用户程序去操作；
- ET（边缘触发）模式下，在它检测到有 I/O 事件时，通过 epoll_wait 调用会得到有事件通知的文件描述符，对于每一个被通知的文件描述符，如可读，则必须将该文件描述符一直读到空，让 errno 返回 EAGAIN 为止，否则下次的 epoll_wait 不会返回余下的数据，会丢掉事件。如果ET模式不是非阻塞的，那这个一直读或一直写势必会在最后一次阻塞。

还有一个特点是，epoll使用“事件”的就绪通知方式，通过epoll_ctl注册fd，一旦该fd就绪，内核就会采用类似callback的回调机制来激活该fd，epoll_wait便可以收到通知。

![image-20230609113817318](/home/ruoyang/.config/Typora/typora-user-images/image-20230609113817318.png)

epoll为什么要有EPOLLET触发模式？】：

如果采用 EPOLLLT 模式的话，系统中一旦有**大量**你**不需要读写**的<strong style="color:red">就绪文件描述符</strong>，它们每次调用epoll_wait都会返回，这样会大大降低处理程序检索自己关心的就绪文件描述符的效率。

而采用EPOLLET这种边缘触发模式的话，当被监控的文件描述符上有可读写事件发生时，epoll_wait()会通知处理程序去读写。

如果这次没有把数据全部读写完(如读写缓冲区太小)，那么下次调用epoll_wait()时，它不会通知你，也就是它只会通知你一次，直到该文件描述符上出现第二次可读写事件才会通知你！！！这种模式比水平触发效率高，系统不会充斥大量你不关心的就绪文件描述符。

【总结】：

- ET模式（边缘触发）只有数据到来才触发，不管缓存区中是否还有数据，缓冲区剩余未读尽的数据不会导致epoll_wait返回；
- LT 模式（水平触发，默认）只要有数据都会触发，缓冲区剩余未读尽的数据会导致epoll_wait返回。

https://blog.csdn.net/u012846795/article/details/125139552