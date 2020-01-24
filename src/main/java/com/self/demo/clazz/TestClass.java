package com.self.demo.clazz;


import com.self.demo.basicType.TestBigdecimal;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
* @Description: class类测试用例
* @Author: javaJoker
* @CreateDate: 2020/1/10 10:54
* @Version: 1.0
*/
public class TestClass {
    public static void main(String[] args) {
        // 基本类型判断
        System.out.println( BigDecimal.class.isPrimitive());
        System.out.println(int.class.isPrimitive());
        System.out.println(void.class.isPrimitive());
        System.out.println( TestBigdecimal.class.isPrimitive());
        System.out.println(Class.class.isPrimitive());

        System.out.println(Integer.TYPE);
        System.out.println("==============");

        // 返回数组的元素类型
        int[] a1 = new int[] {1,2,3,4};
        System.out.println(a1.getClass().getComponentType());
        System.out.println(a1.getClass());
        System.out.println(int.class.getComponentType());

        System.out.println("============");

        // getName
        long[] a2 = new long[] {1,2,3,4};
        String[] a3 = new String[] {"1","2","3","4"};
        System.out.println(Integer.class.getName());
        System.out.println(a1.getClass().getName());
        System.out.println(a2.getClass().getName());
        System.out.println(a3.getClass().getName());
        System.out.println(int.class.getName());
        System.out.println(String.class.getName());
        List<String> str = Arrays.asList( a3 );
        System.out.println(str.getClass().getName());
        System.out.println(str.getClass().isArray());
    }
}
