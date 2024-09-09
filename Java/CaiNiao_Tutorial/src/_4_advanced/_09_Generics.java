package _4_advanced;

public class _09_Generics<T> {
    private T attr1;

    public _09_Generics(T attr1) {
        this.attr1 = attr1;
    }

    public _09_Generics() {
    }

    public T getAttr1() {
        return attr1;
    }

    public void setAttr1(T attr1) {
        this.attr1 = attr1;
    }

    /* 定义一个泛型方法 */
    public <T> T getInfo(T info) {
        return info;
    }
}
