package com.self.demo.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
* @Description: ConcurrentHashMap测试类
* @Author: javaJoker
* @CreateDate: 2020/1/10 10:49
* @Version: 1.0
*/
public class TestConcurrentHashMap {
    public static void main(String[] args) {
        System.out.println(1 << 16 - 1);
        System.out.println( 16 >>> 16);
        System.out.println(Integer.numberOfLeadingZeros(16) | (1 << (16 - 1)));


//        test1();
    }

    private static void test1() {
        ConcurrentHashMap cMap = new ConcurrentHashMap();
        cMap.put( "1", "1" );
        cMap.put( "2", "2" );
        System.out.println(cMap.hashCode());

        Map map= new HashMap();
        map.put( "21", "222" );
        System.out.println(map.hashCode());
    }
}
