package iterator_pattern.test2;

/* 具体迭代器 (具体产品角色)*/
public class ConcreteIterator implements Iterator {

  private ConcreteAggregate objects;
  private int cursor; // 游标, 记录当前访问的位置

  public ConcreteIterator(ConcreteAggregate objects) {
    this.objects = objects;
  }

  @Override
  public Object first() {
    return null;
  }

  @Override
  public Object next() {
    return null;
  }

  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public Object currentItem() {
    return null;
  }
}
