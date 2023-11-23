#!/usr/bin/env python3
# 进程process 线程thread
# 多任务：
#   多进程模型，多进程单线程
#   多线程模型，单进程多线程
#   多进程+多线程模型，多进程多线程

# 多进程
import os
# print("process (%s) start ..." % os.getpid())
# pid=os.fork()
# if pid:
#     print("parent process %s" % os.getpid())
# else:
#     print("I'm child process %s, my parent process id is %s" % (os.getpid(),os.getppid()))
    
# multiprocessing
from multiprocessing import Process
import os

def func(name):
    print("-------Run child process %s."%os.getpid())
def main():
    print("parent process %s."%os.getpid())
    p=Process(target=func,args=("test",))
    print("child process will start.")
    p.start()
    p.join()
    print("child process end.")
    
from multiprocessing import Process,Pool
import os,time,random

def long_time_task(name):
    print("Run task %s (%s)..." % (name,os.getpid()))
    start=time.time()
    time.sleep(random.random()*3)
    end=time.time()
    print("task %s runs %0.2f seconds."%(name,(end-start)))
def main2():
    print("Parent process %s."%os.getpid())
    p=Pool(4)
    for i in range(5):
        p.apply_async(long_time_task,args=(i,))
    print("Waiting for all subprocess done...")
    p.close()
    p.join()
    print("all subprocesses done")
        
# if __name__=="__main__":
#     # main()
#     # main2()
#     pass
    
# 子进程
import subprocess
def test_subprocess():
    # r=subprocess.call(["nslookup","www.baidu.com"])
    # print(r)
    print("$ nslookup")
    p=subprocess.Popen(["nslookup"],stdin=subprocess.PIPE,stdout=subprocess.PIPE,stderr=subprocess.PIPE)
    output,err=p.communicate(b"set q=mx\npython.org\nexit\n")
    print(output.decode("utf-8"))
    print("Exit code:",p.returncode)
    
# test_subprocess()

# IPC inter-process communication
from multiprocessing import Process,Queue
import os,time,random

def write(q):
    print("写进程 %s "%os.getpid())
    for value in ["A","B","C"]:
        print("Put %s to queue..."% value)
        q.put(value)
        time.sleep(random.random())

def read(q):
    print("读进程 %s"%os.getpid())
    while True:
        value=q.get(True)
        print("Get %s from queue."%value)

def test_IPC():
    q=Queue()
    pw=Process(target=write,args=(q,))
    pr=Process(target=read,args=(q,))
    pw.start()
    pr.start()
    pw.join()
    pr.terminate()
    
# test_IPC()

# 多线程
import time,threading
def loop():
    print("thread %s is running..." % threading.current_thread().name)
    n=0
    while n<5:
        n=n+1
        print("thread %s >>> %s"%(threading.current_thread().name,n))
        time.sleep(1)
    print("thread %s ended."% threading.current_thread().name)

def test_loop():
    print("thread %s is running..."%threading.current_thread().name)
    t=threading.Thread(target=loop,name="LoopThread-hhh")
    t.start()
    t.join()
    print("thread %s ended."% threading.current_thread().name)
    
# test_loop()

# Lock , 多个线程读写同一个变量
import time ,threading

balance=0
lock=threading.Lock()#

def change_it(n):
    global balance
    balance=balance+n
    balance=balance-n
    
def run_thread(n):
    for i in range(2000_000):
        lock.acquire()#
        try:#
            change_it(n)
        finally:#
            lock.release()#

def test_lock():
    t1=threading.Thread(target=run_thread,args=(5,))
    t2=threading.Thread(target=run_thread,args=(8,))
    t1.start()
    t2.start()
    t1.join()
    t2.join()
    print(balance)

# test_lock()

# 多核CPU
import threading,multiprocessing
def loop2():
    x=0
    while True:
        x=x^1
        
def test_loop2():
    for i in range(multiprocessing.cpu_count()):
        t=threading.Thread(target=loop2)
        t.start()

# test_loop2() # CPU利用率只有100%，而不是200%
# Global Interpreter Lock，任何Python线程执行前，必须先获得GIL锁，然后，每执行100条字节码，解释器就自动释放GIL锁，让别的线程有机会执行

# ThreadLocal
class Student(object):
    def __init__(self,name):
        self.name=name
def do_subtask_1(args):
    pass
def do_subtask_2(args):
    pass

def process_student(name):
    std = Student(name)
    # std是局部变量，但是每个函数都要用它，因此必须传进去：
    do_task_1(std)
    do_task_2(std)

def do_task_1(std):
    do_subtask_1(std)
    do_subtask_2(std)

def do_task_2(std):
    do_subtask_2(std)
    do_subtask_2(std)

# 使用global dict
global_dict={}
def std_thread(name):
    std = Student(name)
    # 把std放到全局变量global_dict中：
    global_dict[threading.current_thread()] = std
    do_task_11()
    do_task_22()

def do_task_11():
    # 不传入std，而是根据当前线程查找：
    std = global_dict[threading.current_thread()]
    ...

def do_task_22():
    # 任何函数都可以查找出当前线程的std变量：
    std = global_dict[threading.current_thread()]
    ...
print("----------")

# 使用ThreadLocal
import threading
local_school = threading.local()

def process_student():
    std = local_school.student
    print('Hello, %s (in %s)' % (std, threading.current_thread().name))
    
def process_thread(name):
    local_school.student = name
    process_student()
    
t1 = threading.Thread(target=process_thread, args=("Stu1",), name="Thread_A")
t2 = threading.Thread(target=process_thread, args=("Stu2",), name="Thread_B")
t1.start()
t2.start()
t1.join()
t2.join()

# 多进程 vs 多线程
# 多进程：优点稳定性高，缺点创建开销大
# 多线程：优点比多进程快，缺点一个线程错误可能导致整个应用崩溃
# 多任务一旦多到一个限度，就会消耗掉系统所有的资源，结果效率急剧下降，所有任务都做不好

# 计算密集型 vs. IO密集型
# 计算密集型任务的特点是要进行大量的计算，主要消耗CPU资源。脚本语言运行效率很低，完全不适合计算密集型任务。对于计算密集型任务，最好用C语言编写
# IO密集型特点是CPU消耗很少，任务的大部分时间都在等待IO操作完成，最合适的语言就是开发效率最高（代码量最少）的语言，脚本语言是首选，C语言最差

# 异步IO
# 现代操作系统对IO操作做的巨大改进就是支持异步IO
# 事件驱动模型
# Python语言，单线程的异步编程模型称为协程，有了协程的支持，就可以基于事件驱动编写高效的多任务程序
# 见task_master.py
# 见task_worker.py
