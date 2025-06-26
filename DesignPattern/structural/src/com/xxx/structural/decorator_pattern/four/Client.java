package com.xxx.structural.decorator_pattern.four;

public class Client {
  public static void main(String[] args) {

    /* 半透明模式: 具体组件使用抽象组件声明, 具体装饰器使用具体装饰器类型声明 */
    /* 对于客户端而言，具体组件类型无须关心，是透明的；但是【具体装饰类型】必须指定，这是不透明的 */
    Document doc;
    // 组件,
    doc = new PurchaseRequest();
    /* 具体装饰器 */
    Approver newDoc; // 这里不能使用 Document 类型, 否则无法调用 装饰器 新增的业务方法
    // 装饰器
    newDoc = new Approver(doc);
    newDoc.display(); // 调用原有业务方法
    newDoc.approve(); // 调用新增的业务方法

    /* 具体装饰器 */
    Deleter newDocDelete;
    newDocDelete = new Deleter(newDoc);
    newDocDelete.display();
    newDocDelete.delete();
  }
}
