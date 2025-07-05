package iterator_pattern.test3;

import java.util.ArrayList;
import java.util.List;

/* 抽象聚合类 */
public abstract class AbstractObjectList {
  protected List<Object> objects = new ArrayList<>();

  public AbstractObjectList(List<Object> objects) {
    this.objects = objects;
  }

  public void addObject(Object o) {
    objects.add(o);
  }

  public void removeObject(Object o) {
    objects.remove(o);
  }

  public List<Object> getObjects() {
    return objects;
  }

  public abstract AbstractIterator createIterator();

}
