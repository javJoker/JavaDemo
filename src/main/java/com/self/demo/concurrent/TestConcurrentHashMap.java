package com.self.demo.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap cMap = new ConcurrentHashMap();
        cMap.put( "1", "1" );
        cMap.put( "2", "2" );
        System.out.println(cMap.hashCode());

        Map map= new HashMap();
        map.put( "21", "222" );
        System.out.println(map.hashCode());
    }
}
