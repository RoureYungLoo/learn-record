package iterator_pattern.test4;

/* 抽象迭代器(抽象产品角色) */
public interface AbstractIterator {
  void next();

  boolean isLast();

  void previous();

  boolean isFirst();

  Object getNextItem();

  Object getPreviousItem();
}
