package _3_oop;

import _3_oop.animals.MammalInt;
import java.util.ArrayList;
import java.util.LinkedList;
import _3_oop.Employee;

/**
 * java package的作用：
 *  1. 避免类名冲突
 *  2. 限定访问权限
 *  3. 方便查找定位（ class、interface、enum、annotation ）
 * */
// package pkg1.pkg2.pkg3.xxx;
public class _08_Package {
    public static void main(String[] args) {
        MammalInt m = new MammalInt();
        m.eat();
        m.travel();
    }
}

/* import */
// import pkg1.pkg2.pkg3.classname;
// import pkg1.pkg2.pkg3.*;  导入包中的所有类，不包括子包

class MyPig {
    //
}

// 声明顺序：包声明、导入声明、类声明：package、import、class

// 类放在包中会有两种主要的结果：
//   1. 包名成为类名的一部分
//   2. 包名必须与相应的字节码所在的目录结构相吻合


/* class path */
// 类目录的绝对路径叫做 class path
// 编译器和 java 虚拟机通过将 package 名字加到 class path 后来构造 .class 文件的路径