package com.self.demo.map;

import com.self.demo.model.Department;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap();
        map.put( "22", "12222" );
        map.get( "22" );

        Map<String, String> map2 = new HashMap();
        map2.put( "22", "12222" );
        System.out.println(map.equals( map2 ));

        Object a = new Object();
        Object b = new Object();
        System.out.println(a.equals( b ));
//        test2();
//        test3();

    }

    private static void test3() {
        //        Map<String, String> map = null ;
//        System.out.println(map.isEmpty());
        Map<String, String> map = new HashMap();
//        for (int i=0; i < 21; i++){
//            map.put( i + "", "1111" );
//        }
        map.put( "22", "12222" );
        map.put( "", "12222" );
        map.put( null, "12222" );
        map.put( "25", null );
        map.keySet();
//        for (String key : map.keySet()){
//            System.out.println("key:" + key + ",value:" + map.get( key ));
//        }

//
//        map.put( null, null );
//        System.out.println(map.get( null ));
    }

    private static void test2() {
        Department a = new Department(  1, "b" );
        Department b;
        test( b = a );
        System.out.println(b.getDeptName());
        System.out.println(a.getDeptName());
    }

    private static void test(Department temp){
        temp.setDeptName( "cccc" );
    }


    private static void test1() {
        Map<String, String> map = new HashMap<>(16);
        map.put( "1", "1" );
        map.put( "2", "2" );
        map.put( "3", "3" );
        map.put( "4", "4" );
//
//        System.out.println();
//
//        System.out.println(1 << 30);
//        System.out.println(tableSizeFor(1073741824 ));
//        System.out.println(Integer.MAX_VALUE);
    }

    static final long tableSizeFor(int cap) {
        int n = cap - 1;
//        long n = cap ;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }
}
