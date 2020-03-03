package com.self.demo.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * List 方法测试类
 */
public class TestListMethod {
    public static void main(String[] args) {
        testSubList();

    }

    private static void testSubList() {
        String[] arr = new String[99];
        for ( int i=0; i < 99; i++ ){
            arr[i] = "a" + i;
        }
        List list = Arrays.asList(arr);

        long startFor = System.currentTimeMillis();
        List result  = new ArrayList();
        for (int i=0; i < 99; i ++){
            result.add( list.get( i ) );
        }

        System.out.println("for:" + (System.currentTimeMillis() - startFor));


        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long startSubList = System.currentTimeMillis();

        List subList = list.subList( 0, 9 );

        System.out.println("subList:" + (System.currentTimeMillis() - startSubList));

        System.out.println(list.hashCode());
        System.out.println(subList.hashCode());


        System.out.println("subList:" + subList.toString() );
    }
}
