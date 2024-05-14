package _2_official_utils;

public class _04_BufferAndBuilder {
    /* 可修改的字符串 StringBuffer【线程安全】、StringBuilder【非线程安全】 */

    public static void main(String[] args) {
        /* StringBuilder 【非线程安全】 */
        StringBuilder sb = new StringBuilder(10);
        sb.append("Hello");
        sb.append(" ");
        sb.append("World");
        System.out.println(sb);

        sb.insert(3,"^");
        System.out.println(sb);

        sb.delete(3,4);
        System.out.println(sb);

        /* StringBuffer 【线程安全】*/
        StringBuffer sBuffer = new StringBuffer();
        sBuffer.append("he<1>ll");
        sBuffer.append("o ");
        sBuffer.append("Wo2rld");
        System.out.println(sBuffer);
    }
}
