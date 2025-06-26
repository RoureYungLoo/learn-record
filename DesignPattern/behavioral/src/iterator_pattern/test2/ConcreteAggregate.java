package iterator_pattern.test2;

/* 具体聚合类 (具体工厂角色)*/
public class ConcreteAggregate implements Aggregate {
  @Override
  public Iterator createIterator() {
    return new ConcreteIterator(this);
  }
}
