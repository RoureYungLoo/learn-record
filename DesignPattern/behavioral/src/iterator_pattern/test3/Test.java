package iterator_pattern.test3;

import java.util.ArrayList;
import java.util.List;

public class Test {
  public static void main(String[] args) {
    List products = new ArrayList();
    products.add("张三");
    products.add("李四");
    products.add("王五");
    products.add("赵六");
    products.add("田六");

    AbstractObjectList list;
    AbstractIterator iterator;

    list = new ProductList(products);
    iterator = list.createIterator();

    System.out.println("正向遍历");
    while (!iterator.isLast()) {
      System.out.print(iterator.getNextItem() + ", ");
      iterator.next();
    }

    System.out.printf("\n逆向遍历\n");
    while (!iterator.isFirst()) {
      System.out.print(iterator.getPrevious() + ", ");
      iterator.previous();
    }
  }
}
