package _1_base._06_var_name_rule;

/* 类名 */
public class VarNameRule {
    /*
     * 1. 见名知义
     * 2. 驼峰：myVarName
     * 3. 非关键字
     * 4. 区分大小写
     * 5. 非数字开头
     * */

    /* 实例变量名*/
    private int myInstanceVar;
    /* 类变量名 */
    private static int myStaticVar;
    /* 常量名 */
    private static final int MY_CONST_VAR = 200;

    public static void method(int myParamVar) { /* 形参名 */
        /* 局部变量名 */
        int myLocalVar;
    }

}
