package iterator_pattern.test1;

import java.util.List;
import java.util.Objects;

/* 本类职责过重 */
public abstract class AbstractObjectList {
  private List<Object> objects;

  public AbstractObjectList(List<Object> objects) {
    this.objects = objects;
  }

  /* 管理数据 */
  abstract void addObject();

  /* 管理数据 */
  abstract void removeObject();

  abstract List<Object> getObjects();

  /* 遍历数据 */
  abstract void next();

  /* 遍历数据 */
  abstract boolean isLast();

  /* 遍历数据 */
  abstract boolean isFirst();

  /* 遍历数据 */
  abstract void previous();

  abstract Object getNextItem();

  abstract Object getPreviousItem();
}
