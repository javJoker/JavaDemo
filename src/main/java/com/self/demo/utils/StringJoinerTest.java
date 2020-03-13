package com.self.demo.utils;

import java.util.StringJoiner;

/**
 * @description:
 * @author: JavJoker
 * @date: Created in 2020/3/9 22:29
 * @version: v1.0
 * @modified By:
 */
public class StringJoinerTest {
    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner(",", "<", ">");
        System.out.println(stringJoiner.toString());
    }
}
