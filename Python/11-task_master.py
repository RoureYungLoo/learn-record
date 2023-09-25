#!/usr/bin/python

import random, time, queue
from multiprocessing.managers import BaseManager

# 发送任务的队列:
task_queue = queue.Queue()
# 接收结果的队列:
result_queue = queue.Queue()

# 从BaseManager继承的QueueManager:
class QueueManager(BaseManager):
    pass

def get_task_q():
    return task_queue
def get_result_q():
    return result_queue

if __name__ == '__main__':
    # 把两个Queue都注册到网络上, callable参数关联了Queue对象:
    QueueManager.register("get_task_queue",callable=get_task_q)
    QueueManager.register("get_result_queue",callable=get_result_q)

    # 绑定端口5000, 设置验证码'abc':
    manager = QueueManager(address=('127.0.0.1',5000), authkey=b'abc')
    manager.start() # 启动Queue:

    # 获得通过网络访问的Queue对象:
    task = manager.get_task_queue()
    result = manager.get_result_queue()

    # 放几个任务进去:
    for i in range(10):
        n =  random.randint(0,10000)
        print("put task %d..."%n)
        task.put(n)

    # 从result队列读取结果:
    print('Try get results...')
    for i in range(10):
        r = result.get(timeout=10)
        print("Result: %s" %r )

    # 关闭: 
    manager.shutdown()
    print("master exit.")


# 以下部分是v2
#!/usr/bin/env python3
# task_master.py

# distributed multi process, task manager
from multiprocessing import managers
import random, time, queue
from multiprocessing.managers import BaseManager

# queue that send tasks
task_queue = queue.Queue()
# queue that receive tasks
result_queue = queue.Queue()

class QueueManager(BaseManager):
    pass

def get_task_q():
    return task_queue
def get_result_q():
    return result_queue

if __name__ == '__main__':
    # register two queues to network
    QueueManager.register('get_task_queue', callable=get_task_q)
    QueueManager.register('get_result_queue', callable=get_result_q)
    # bind to port 5000, authentication code abc
    manager = QueueManager(address=('127.0.0.1', 5000), authkey=b'abc')

    # start the manager
    manager.start()
    # get Queue object through network
    task = manager.get_task_queue()
    result = manager.get_result_queue()

    # put some tasks to task queue
    for i in range(5):
        n = random.randint(0, 10000)
        print(f"Put task {n}")
        task.put(n)

    # read result from result queue
    print("Try get results...")
    for i in range(10):
        try:
            r = result.get(timeout=5)
            print(f"Result : {r}")
        except queue.Empty:
            print("The queue is empty...")

    # shudown manager
    print("Master exit.")
