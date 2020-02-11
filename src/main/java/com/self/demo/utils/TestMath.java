package com.self.demo.utils;

/**
 * Math 方法测试类
 * @author javaJoker
 */
public class TestMath {

    public static void main(String[] args) {
//        test2();
        //        testCeil();
    }

    private static void test2() {
        // 无符号右移的向下取整
        System.out.println(24 >>> 3);
    }

    private static void testCeil() {
        double temp = 8.2;
        System.out.println(Math.ceil( temp ));
    }
}
