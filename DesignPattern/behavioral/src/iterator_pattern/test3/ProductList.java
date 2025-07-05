package iterator_pattern.test3;

import java.util.List;

/* 具体聚合类 */
public class ProductList extends AbstractObjectList {
  public ProductList(List objects) {
    super(objects);
  }

  @Override
  public AbstractIterator createIterator() {
    return new ProductIterator(this);
  }
}
