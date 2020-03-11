package com.self.demo.concurrent;

/**
 * @Description: TODO
 * @Author javaJoker
 * @Date 2020/3/4
 * @Version V1.0
 **/
public class SynchronizedTest {
    static int c;
    public static void main(String[] args) {
        int a = 0;
        a = a + 1;
        a = a + 1;
        int b = 0;
        Integer i1;
        Integer i2 = new Integer(2);
        System.out.println(c);
    }


}
