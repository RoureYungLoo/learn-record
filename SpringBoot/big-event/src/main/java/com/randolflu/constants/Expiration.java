package com.randolflu.constants;

import java.math.BigInteger;

public class Expiration {
    public static final Long AMinute = System.currentTimeMillis() + 1000 * 60L;
    public static final Long AnHour = System.currentTimeMillis() + 1000 * 60 * 60L;
    public static final Long ADay = System.currentTimeMillis() + 1000 * 60 * 60 * 24L;
    public static final Long HalfAnHour = System.currentTimeMillis() + 1000 * 60 * 30L;
    public static final Long TwoHours = System.currentTimeMillis() + 1000 * 60 * 60 * 2L;
}
