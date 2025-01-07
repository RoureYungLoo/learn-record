package linear.queue;

import java.lang.reflect.Modifier;

/* 循环双端队列 */
public class MyCircularDeque {
    int front = 0, rear = 0, arr[], MaxSize = 0;

    public MyCircularDeque(int k) {
        arr = new int[k + 1];
        MaxSize = k + 1;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + MaxSize) % MaxSize;
        arr[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        arr[rear] = value;
        rear = (rear + 1) % MaxSize;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % MaxSize;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + MaxSize) % MaxSize;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;

        return arr[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;

        return arr[(rear - 1 + MaxSize) % MaxSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % MaxSize == front;
    }
}
