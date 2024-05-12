package _1_base._07_modifier;

public class Modifier {
    /* 访问控制修饰符 */
    /* default   */
    /* private   */
    /* public    */
    /* protected */

    /* 非访问控制修饰符 */
    /* static */
    /* final */
    /* abstract */
    /* synchronized */
    /* volatile */
    /* transient */

    private boolean flag;
    /* default */ static final double weeks = 9.5;
    protected static final int WIDTH = 420;

    public static void main(String[] args) {
        Clazz clz = new Clazz();
        clz.display();
        clz.print();

        SonClazz sonClazz = new SonClazz();
        sonClazz.print();

        System.out.println("start with " + InstanceCounter.getCount() + " instances");
        for (int i = 0; i < 50; i++) {
            new InstanceCounter();
        }
        System.out.println("created " + InstanceCounter.getCount() + " instances");
    }

}

class Clazz {
    /* default */
    int x = 10;

    void display() {
        System.out.println("x = " + x);
    }

    /* private */
    private String format;

    /* public */
    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    protected void print() {
        System.out.println("基类protected方法");
    }
}

class SonClazz extends Clazz {
    protected void print() {
        super.print(); // 基类protected方法
        System.out.println("子类protected方法");
    }
}

/* static */
class InstanceCounter {
    private static int numInstances = 0;

    protected static int getCount() {
        return numInstances;
    }

    private static void addInstance() {
        numInstances++;
    }

    InstanceCounter() {
        InstanceCounter.addInstance();
    }
}

/* final */
final class z {
    final int age = 10;
    static final int HEIGHT = 177;
    final static String TITLE = "Manager";

    final void getInfo() {
        System.out.println(TITLE);
    }
}

/*
    class y extends z { //Cannot inherit from final 'java_07_modifier.z'

    }
 */

/* abstract */
abstract class Caravan {
    private double price;
    private String model;
    private String year;

    abstract void goFast();

    abstract void changeColor();
}

/* transient、synchronized */
class Sender{
    public transient int limit =55; //不会持久化
    public int b; //持久化
    public synchronized void showDetails(){

    }
}

/* volatile */
class MyRunnable implements Runnable{
// volatile 修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值。
// 而且，当成员变量发生变化时，会强制线程将变化值回写到共享内存。这样在任何时刻，
// 两个不同的线程总是看到某个成员变量的同一个值。
    private volatile boolean active;

    @Override
    public void run() {
        active = true;
        while (active){
            System.out.println("running");
        }
    }
    public void stop(){
        active=false;
    }
}