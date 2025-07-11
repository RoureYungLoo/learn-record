package iterator_pattern.test3;


import java.util.List;

/* 具体迭代器 */
public class ProductIterator implements AbstractIterator {
  private ProductList productList; // 依赖(访问)具体聚合类对象
  private List products;
  private int cursor1;
  private int cursor2;

  public ProductIterator(ProductList list) {
    productList = list;
    products = list.getObjects();
    cursor1 = 0;
    cursor2 = products.size() - 1;
  }

  @Override
  public void next() {
    if (cursor1 < products.size()) {
      cursor1++;
    }
  }

  @Override
  public boolean isLast() {
    return cursor1 == products.size();
  }

  @Override
  public void previous() {
    if (cursor2 > -1) {
      cursor2--;
    }
  }

  @Override
  public boolean isFirst() {
    return cursor2 == -1;
  }

  @Override
  public Object getNextItem() {
    return products.get(cursor1);
  }

  @Override
  public Object getPrevious() {
    return products.get(cursor2);
  }
}
