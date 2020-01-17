package com.self.demo;

import com.self.demo.model.Department;
import com.self.demo.model.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    int i = 0;

    public static void main(String[] args) {

        // 获取cpu核心数
        System.out.println(Runtime.getRuntime().availableProcessors());

        float d1 = 1.0f;
        float d2 = 0.9f;
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d1 - d2);

        float a1 = 0.9f;
        float a2 = 0.8f;
        System.out.println(a1 - a2);

        System.out.println(Float.parseFloat( d1 + "" ) - Float.parseFloat(d2 + "") );
        System.out.println(Float.valueOf( a1 - a2 ));

        BigDecimal b1 = new BigDecimal( d1 );
        BigDecimal b2 = new BigDecimal( d2 );
        System.out.println(b1.subtract( b2 ));

        BigDecimal b3 = new BigDecimal( a1 );
        BigDecimal b4 = new BigDecimal( a1 );
        System.out.println(b3.subtract( b4 ));


        BigDecimal c1 = new BigDecimal( Double.parseDouble( "1.0" ) );
        BigDecimal c2 = new BigDecimal( Double.parseDouble( "0.9" ));
        System.out.println(c1.subtract( c2 ));

        BigDecimal c3 = new BigDecimal( Double.parseDouble( "0.9" ) );
        BigDecimal c4 = new BigDecimal( Double.parseDouble( "0.8" ) );
        System.out.println( new BigDecimal( 1e-7 ).toString() );
        System.out.println(c3.subtract( c4 ).compareTo( new BigDecimal( 1e-7 ) ));

//        String[] str = {"aaas", "bbbb","c","d"};

//        System.out.println(Long.MAX_VALUE + Long.MIN_VALUE);

//        int i2 = 76430;
//        System.out.println((i2 * 52429) >>> (16+3));
//        System.out.println((i2 * 52429)/524288);

//        System.out.println();
//        long q = 123123147125789L;
//        System.out.println(q / 100);
//        System.out.println((q >> 6) + (q >> 5) + (q >> 2));
//
//
//        long q1 = 125789L;
//        System.out.println(q1 * 100);
//        System.out.println((q1 << 6) + (q1 << 5) + (q1 << 2));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Math.pow( 2, 19 ));
//        System.out.println(Math.pow( 2, 5 ));
//        System.out.println(Math.pow( 2, 2 ));

//        System.out.println( 4 & 3);
//        System.out.println(Main.stringSize(9223372036854775807L));
//        System.out.println(Long.MIN_VALUE);
//
//        String str = "bx0001-ax0002-cs3333";
//        System.out.println(str.substring( str.indexOf( "ax" ) + "ax".length(), str.indexOf( "-", str.indexOf( "ax" ) ) ));

//        testTypeMemory();

//        System.out.println(System.getProperties());
//        System.out.println(System.getenv());
//        System.out.println(System.getProperty("encoding"));
//        System.out.println(Boolean.getBoolean( "ANT_HOME" ));

//        test();


//        testMap();

//        testStringArray();

//        testInternalObjConstructor();

//        List<User> userList = new ArrayList<>( );
//
//        userList.forEach( user -> {
//            System.out.println("=-=====");
//        } );

//        System.out.println(0.1*3);
//
//        float f = 0.1f;
//        System.out.println(f);
//        System.out.println(f*3);
//        System.out.println(0.1);
//
//        BigDecimal bdf = new BigDecimal( 0.1 );
//        System.out.println(bdf.multiply( new BigDecimal( 3 )));
    }



    static int stringSize(long x) {
        long p = 10;

        for (int i=1; i<19; i++) {
            if (x < p)
                return i;
            p = 10*p;
        }
        return 19;
    }

    private static void testTypeMemory() {
        System.out.println("Integer");
        Integer i1 = 100;
        System.out.println(System.identityHashCode( i1 ));
//        Integer i2 = 1;
        i1 = 127;
        System.out.println(i1);
        System.out.println(System.identityHashCode( i1 ));
//        System.out.println(System.identityHashCode( i2 ));
        System.out.println("----------------");

        System.out.println("int");
        int i = 127;
        System.out.println("值" + i);
        System.out.println("内存地址：" + System.identityHashCode( i ));
        int i2 = 127;
        System.out.println("值" + i2);
        System.out.println("内存地址：" + System.identityHashCode( i2 ));
        i = 127;
        System.out.println("值" + i);
        System.out.println("内存地址：" + System.identityHashCode( i ));
        i =128;
        System.out.println("值" + i);
        System.out.println("内存地址：" + System.identityHashCode( i ));
        i2 = 128;
        System.out.println("值" + i2);
        System.out.println("内存地址：" + System.identityHashCode( i ));

        System.out.println("----------------");
        System.out.println("String");
        String s = "1111";
        System.out.println(System.identityHashCode( s ));
        s = "1222";
        System.out.println(s);
        System.out.println(System.identityHashCode( s ));

        System.out.println("----------------");
        System.out.println("String");
        String s1 = "1111";
        System.out.println(System.identityHashCode( s1 ));
        s1 = "1222";
        System.out.println(s1);
        System.out.println(System.identityHashCode( s1 ));

        System.out.println("----------------");
        System.out.println("StringBuffer");

        StringBuffer sb = new StringBuffer( "11" );
        System.out.println(System.identityHashCode( sb ));
        sb.append( "cccc" );
        System.out.println(sb.toString());
        System.out.println(System.identityHashCode( sb ));
    }

    private static void test() {
        Integer a = null;
        Integer b = 1;
        if (a < b){
            System.out.println(111);
        }
    }

    private static void testInternalObjConstructor() {
        User user = new User();
        Department dept = user.getDept();
        if (null == dept){
            System.out.println("======" + dept.getDeptName());
            System.out.println(111);
        }
    }

    private static void testStringArray() {
        System.out.println("==================");
        String[] temp1 = new String[]{"1","2","3"};
        System.out.println();
    }

    private static void testMap() {
        Map<String, String> map = new HashMap(  );
        map.put( "k1", "v1" );
        map.put( "k2", "v2" );
        String temp = map.keySet().iterator().next();
        System.out.println( temp );
    }
}
