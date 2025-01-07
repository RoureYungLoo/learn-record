package linear.queue;

public class Main {
    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        System.out.println(queue);
        System.out.println(queue.getQueueLen());


    }

}