package iterator_pattern.test2;

/* 抽象迭代器 (抽象产品角色) */
public interface Iterator {
  Object first();

  Object next();

  boolean hasNext();

  Object currentItem();
}
