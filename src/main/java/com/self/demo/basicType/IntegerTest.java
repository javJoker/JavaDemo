package com.self.demo.basicType;

import java.util.Arrays;
import java.util.stream.Stream;

public class IntegerTest {
    public static void main(String[] args) {
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 2});

        //求集合元素只和
        Integer result = stream.reduce(2, Integer::sum);
        System.out.println(result);
    }
}
