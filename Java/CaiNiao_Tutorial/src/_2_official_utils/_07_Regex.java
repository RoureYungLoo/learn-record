package _2_official_utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _07_Regex {
    public static void main(String[] args) {
        /* 正则表达式 Regular Expressions */
        String content = "I am a person.People " + "from China.";
        String pattern = ".*erson.*";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("isMatch：" + isMatch);

        String line = "This order was placed for QT3000! OK?";
        String pattern2 = "(\\D*)(\\d+)(.*)"; // 正则表达式字符串

        /* 创建 Pattern 对象 */
        Pattern ptn = Pattern.compile(pattern2);

        /* 创建 Matcher 对象*/
        Matcher mcr = ptn.matcher(line);
        if (mcr.find()) {
            System.out.println(mcr.group(0));
            System.out.println(mcr.group(1));
            System.out.println(mcr.group(2));
            System.out.println(mcr.group(3));
        } else {
            System.out.println("NO MATCH");
        }

        /* 在Java语言中，正则表达式 1个 \ 需要2个 \\ 进行转义 */


        String REGEX = "\\bcat\\b";
        String INPUT = "cat cat cat cattie cat";

        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);
        int count = 0;
        while (m.find()) {
            count++;
            System.out.println("Match number: " + count);
            System.out.println("start(): " + m.start());
            System.out.println("end(): " + m.end());
        }

        // test1();
        // test2();
        test3();
    }

    /* matches()、lookingAt() */
    public static void test1() {
        String REGEX = "foo";
        String str1 = "fooooooooooooooooo";
        String str2 = "ooooofoooooooooooo";

        Pattern ptn;
        Matcher mhr1;
        Matcher mhr2;

        ptn = Pattern.compile(REGEX);
        mhr1 = ptn.matcher(str1);
        mhr2 = ptn.matcher(str2);

        System.out.println("mhr1.lookingAt(): " + mhr1.lookingAt());
        System.out.println("mhr1.matches(): " + mhr1.matches());
        System.out.println("mhr2.lookingAt(): " + mhr2.lookingAt());
        System.out.println("mhr2.matches()" + mhr2.matches());
    }

    /* replaceFirst()、replaceAll() */
    public static void test2() {
        String regex = "dog";
        String str = "The dog says meow. " + "All dogs say meow.";
        String replace = "cat";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        // str = m.replaceFirst(replace);
        str = m.replaceAll(replace);
        System.out.println(str);
    }

    /* appendReplacement()、appendTail() */
    public static void test3(){
        String regex = "a*b";
        String str = "aabfooaabfooabfoobkkk";
        String rep = "-";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);

        StringBuffer sb = new StringBuffer();
        while (m.find()){
            m.appendReplacement(sb,rep);
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }

    /* PatternSyntaxException 异常类 */
}
