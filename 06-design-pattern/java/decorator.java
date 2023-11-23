// 定义: 指在不改变现有对象结构的情况下，动态地给该对象增加一些职责（即增加其额外功能）的模式.
// 类别: 对象结构型模式
// 角色:  Component、Decorator、ConcreteComponent、ConcreteDecorator
// package java;
public class DecoratorPattern{
    public static void main(String[] args) {
         Component p=new ConcreteComponent();
         p.operation();
         System.out.println("\n");
         Component d=new ConcreteDecorator(p);
         d.operation();
    }
}

interface Component{
    public void operation();
}

class ConcreteComponent implements Component{
    public ConcreteComponent(){
        System.out.println("创建ConcreteComponent角色");
    }
    public void operation(){
        System.out.println("调用ConcreteComponent角色的方法operation()");
    }
}

class Decorator implements Component{
    private Component component;
    public Decorator(Component component){
        this.component=component;
    }
    public void operation(){
        component.operation();
    }
}

class ConcreteDecorator extends Decorator{
    public ConcreteDecorator(Component component){
        super(component);
    }
    public void operation(){
        super.operation();
        addedFunction();
        addedFunction2();
    }
    public void addedFunction(){
        System.out.println("为ConcreteComponent角色增加额外的功能addedFunction()");
    }
    public void addedFunction2(){
        System.out.println("为ConcreteComponent角色增加额外的功能addedFunction2()");
    }
}