package _2_official_utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class _06_DateAndTime {
    public static void main(String[] args) {
        Date d1 =new Date();
        System.out.println(d1);
        System.out.println(d1.toString());
        System.out.println(d1.getTime());

        /* 日期比较 */
        Date d2 = new Date(99,12,24);
        System.out.println(d1.before(d2));
        System.out.println(d1.after(d2));
        System.out.println(d1.equals(d2));
        System.out.println(d1.compareTo(d2));

        /* 日期格式化*/
        String fmt = "yyyy-MM-dd HH:MM:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        System.out.println(sdf.format(d1));
        System.out.println(sdf.format(d2));

        Date date = d1;
        System.out.printf("%tY-%tm-%td %tH:%tM:%tS %tZ\n", date, date, date, date, date, date,date);

        System.out.printf("全部信息：%tc%n",d1);;
        System.out.printf("%tF\n",d1);
        System.out.printf("%tD\n",d1);
        System.out.printf("%tr\n",d1);
        System.out.printf("%tT\n",d1);
        System.out.printf("%tR",d1);
        /* 带参数索引的日期格式化 */
        System.out.printf("%1$s \n %2$tc \n %2$tF \n %2$tD \n %2$tr \n %2$tT \n %2$tR","日期：",d1);
        /* 带 < 的日期格式化*/
        System.out.printf("%1$s \n %2$tc \n %<tF \n %<tD \n %<tr \n %<tT \n %<tR","日期：",d1);

        //b的使用，月份简称
        String str=String.format(Locale.US,"英文月份简称：%tb",date);
        System.out.println(str);
        System.out.printf("本地月份简称：%tb%n",date);
        //B的使用，月份全称
        str=String.format(Locale.US,"英文月份全称：%tB",date);
        System.out.println(str);
        System.out.printf("本地月份全称：%tB%n",date);
        //a的使用，星期简称
        str=String.format(Locale.US,"英文星期的简称：%ta",date);
        System.out.println(str);
        //A的使用，星期全称
        System.out.printf("本地星期的简称：%tA%n",date);
        //C的使用，年前两位
        System.out.printf("年的前两位数字（不足两位前面补0）：%tC%n",date);
        //y的使用，年后两位
        System.out.printf("年的后两位数字（不足两位前面补0）：%ty%n",date);
        //j的使用，一年的天数
        System.out.printf("一年中的天数（即年的第几天）：%tj%n",date);
        //m的使用，月份
        System.out.printf("两位数字的月份（不足两位前面补0）：%tm%n",date);
        //d的使用，日（二位，不够补零）
        System.out.printf("两位数字的日（不足两位前面补0）：%td%n",date);
        //e的使用，日（一位不补零）
        System.out.printf("月份的日（前面不补0）：%te",date);

        System.out.println();
        /* 字符串解析为时间 */
        String yesterday = "2024-05-12 13:23:43";
        try {
            Date yes = sdf.parse(yesterday);
            System.out.println("yesterday: "+yes);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /* 线程休眠 */
        System.out.println(new Date());
        try {
            Thread.sleep(100*3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date());

        /* 时间差计算 */
        try {
            long start,end,diff;
            start = System.currentTimeMillis();
            Thread.sleep(500);
            end = System.currentTimeMillis();
            diff = end- start;
            System.out.println("耗时："+diff+"ms");
        }catch (Exception e){
            e.printStackTrace();
        }

        /* Calendar */
        Calendar c = Calendar.getInstance();
        c.set(2024,5-1,23);
        System.out.println(c.toString());
        /* 设置字段 */
        c.set(Calendar.YEAR,2023);
        /* 日期加减 */
        c.add(Calendar.DAY_OF_MONTH,2);
        c.add(Calendar.DAY_OF_MONTH,-4);
        System.out.println(c.toString());

        /* GregorianCalendar */
        GregorianCalendar grc = new GregorianCalendar();
        System.out.println(grc);

        String months[] = {
                "Jan", "Feb", "Mar", "Apr",
                "May", "Jun", "Jul", "Aug",
                "Sep", "Oct", "Nov", "Dec"};

        int year;
        // 初始化 Gregorian 日历
        // 使用当前时间和日期
        // 默认为本地时间和时区
        GregorianCalendar gcalendar = new GregorianCalendar();
        // 显示当前时间和日期的信息
        System.out.print("Date: ");
        System.out.print(months[gcalendar.get(Calendar.MONTH)]);
        System.out.print(" " + gcalendar.get(Calendar.DATE) + " ");
        System.out.println(year = gcalendar.get(Calendar.YEAR));
        System.out.print("Time: ");
        System.out.print(gcalendar.get(Calendar.HOUR) + ":");
        System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
        System.out.println(gcalendar.get(Calendar.SECOND));

        // 测试当前年份是否为闰年
        if(gcalendar.isLeapYear(year)) {
            System.out.println("当前年份是闰年");
        }
        else {
            System.out.println("当前年份不是闰年");
        }
    }
}
