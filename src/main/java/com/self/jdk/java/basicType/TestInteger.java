package com.self.jdk.java.basicType;

public class TestInteger {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.pow( 2, 19 ));

        String integerCacheHighPropValue = sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
        System.out.println(integerCacheHighPropValue);

        System.out.println(Integer.MAX_VALUE - 128 -1);

        System.out.println(Integer.hashCode( 111 ));
    }
}
