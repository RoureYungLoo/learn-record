package _2_official_utils;

public class _02_Character {
    char ch = 'a';
    char uniCh = '\u039A';
    char[] chs = {'a','b','c', 'd','e'};

    Character ctr = 'x';// 装箱
    char c = test('x'); // 参数装箱，返回拆箱后的基本类型
    public Character test(Character c){
        return c;
    }
}
