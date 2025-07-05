package iterator_pattern.test4;

import java.util.List;

/* 抽象聚合类 （抽象工厂角色） */
public abstract class AbstractObjectList {

  private List<Object> objects;

  public AbstractObjectList(List<Object> objects) {
    this.objects = objects;
  }

  public void addObject() {
  }

  public void removeObject() {
  }

  public List<Object> getObjects() {
    return objects;
  }

  public void createIterator() {
  }
}
