package com.self.demo.basicType;

import java.util.Arrays;
import java.util.stream.Stream;

public class IntegerTest {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(1<<15));

        // 返回指定{@code int}值的二进制补码二进制表示中最高位（“最左侧”）1之前的零位数。
        System.out.println(Integer.numberOfLeadingZeros(16));

//        test1();
    }

    private static void test1() {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 2});

        //求集合元素只和
        Integer result = stream.reduce(2, Integer::sum);
        System.out.println(result);
    }
}
