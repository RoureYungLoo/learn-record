package linear.queue;

/* 这个队列存在假溢出现象 */
public class QueueUsingArray {
    int front = 0;
    int rear = 0;
    int capacity = 10; // 队列容量
    int array[] = new int[1000]; // 底层数据结构是数组

    // 入队
    boolean enqueue(int element) {
        array[rear] = element;
        rear++;
        return true;
    }

    // 出队
    int dequeue() {
        int tmp = array[front];
        front--;
        return tmp;
    }

    int getFront() {
        return array[front];
    }

    int getRear() {
        return array[rear];
    }

    boolean isEmpty() {
        return (rear - front) == 0;
    }

    boolean isFull() {
        return (rear - front) == capacity;
    }

    int getQueueLen() {
        return rear - front;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("queue: [");
        for (int i = front; i < rear; i++) {
            sb.append(array[i]+",");
        }
        int index = sb.lastIndexOf(",");
        sb.deleteCharAt(index);
        sb.append("]");
        return sb.toString();
    }
}