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
        // 添加null字符串
        stringJoiner.add(null);
        stringJoiner.add("1111");
        System.out.println(stringJoiner.toString());

        StringJoiner stringJoiner2 = new StringJoiner("|", "（", "）");
        // 添加null字符串
        stringJoiner2.add("aaaa");
        stringJoiner2.add("bbbb");
        System.out.println(stringJoiner.merge(stringJoiner2));
    }
}
