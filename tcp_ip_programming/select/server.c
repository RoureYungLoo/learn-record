#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/select.h>
#include<sys/time.h>
#include<sys/socket.h>
#include<strings.h>
#include<string.h>
#include<arpa/inet.h>
#include<unistd.h>
#include"mynet.h"



int main()
{
    char buf[SIZE];
    int newfd=-1;//accept返回的、用于通信的socket

    int serv_fd=socket(AF_INET,SOCK_STREAM,0);

    //本机作为服务器角色时的IP和PORT
    struct sockaddr_in local_addr;
    socklen_t local_addr_len=sizeof(local_addr);
    memset(&local_addr,0,local_addr_len);
    local_addr.sin_family=AF_INET;
    local_addr.sin_addr.s_addr=htonl(INADDR_ANY);
    local_addr.sin_port=htons(PORT);

    bind(serv_fd,(struct sockaddr*) &local_addr,local_addr_len);

    listen(serv_fd,5);

    /**
     * select 
    */
   fd_set read_fds;//定义读集合
   FD_ZERO(&read_fds);//清空读集合
   int maxfd=serv_fd;//最大描述符

   while (1)
   {

        FD_SET(0,&read_fds);  //将标准输入加入读集合
        FD_SET(serv_fd,&read_fds);//将fd加入读集合
        maxfd=serv_fd;//表示最大读集合

        if(maxfd<newfd){
            FD_SET(newfd,&read_fds);
            maxfd=newfd;
        }

        int ret=select(maxfd+1,&read_fds, NULL,NULL,NULL);
        if(ret<0){
            perror("select failed");
            exit(1);
        }else if(ret=0){
            perror("select time out");
            exit(1);
        }else{
            if(FD_ISSET(0,&read_fds)){// 判断输入端是否有响应
                memset(buf,0,SIZE);
                fgets(buf,SIZE,stdin);
                printf("shell :%s",buf);
            }
            if(FD_ISSET(serv_fd,&read_fds)){//判断是否有新的客户端连接
                struct sockaddr_in clnt_addr;
                socklen_t clnt_addr_len=sizeof(clnt_addr);
                memset(&clnt_addr,0,clnt_addr_len);
                newfd=accept(serv_fd,(struct sockaddr*)&clnt_addr,&clnt_addr_len);
                if(newfd<0) exit(1);
                printf("客户端 %s:%d 上线",inet_ntoa(clnt_addr.sin_addr),ntohs(clnt_addr.sin_port));
            }
            if(FD_ISSET(newfd,&read_fds)){//判断客户端是否有数据
                memset(buf,0,SIZE);
                int ret=read(newfd,buf,SIZE);
                if (ret==0)
                {
                    FD_CLR(newfd,&read_fds);
                    close(newfd);
                    newfd=-1;
                }else if(ret<0){
                    perror("read failed");
                    exit(1);
                }else{
                    printf("客户端发送的消息：%s\n",buf);
                    if(!strncmp(buf,"quit",4))
                        printf("客户端下线\n");
                }

                
            }
        }
   }
   
     

    
    

    return 0;
}
