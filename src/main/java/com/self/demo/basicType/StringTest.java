package com.self.demo.basicType;

public class StringTest {
    public static void main(String[] args) {
//        test4();

//        test3();

        //        test2();

//        test1();
    }

    private static void test4() {
        String a = "1234567";
        char[] chars = a.toCharArray();
        for (char c : chars){
            System.out.println(c);
        }
    }

    private static void test3() {
        String a = null;
        System.out.println((String) a);
        a.equals( null );

        Integer b = null;
        System.out.println((Integer) b);
    }

    private static void test2() {
        String s1 = "aaaa";
        String s2 = s1;
        s1 = "bbbb";
        System.out.println(s1);
        System.out.println(s2);
    }

    private static void test1() {
        String st1 = new String("a") + new String( "b" );
        System.out.println(System.identityHashCode( st1 ));
//        System.out.println(System.identityHashCode( st1.intern() ));
        String st2 = new String("a" + "b");
        System.out.println(System.identityHashCode( st2 ));
        String st3 = "a" + "b" ;
        System.out.println(System.identityHashCode( st3 ));

        System.out.println("==============");

        String st11 = new String("1") + new String( "1" );
        System.out.println(System.identityHashCode( st11 ));
        String st21 = new String("1" + "1");
        System.out.println(System.identityHashCode( st21 ));
        String st31 = "1" + "1" ;
        System.out.println(System.identityHashCode( st31 ));


//        String s1 = new String("a");
//        System.out.println(System.identityHashCode( s1 ));
//        String s2 = "a";
//        System.out.println(System.identityHashCode( s2 ));
//        System.out.println(System.identityHashCode( s1.intern() ));
//        System.out.println(s1 == s2);

//        String a = new String("123");
//        System.out.println( System.identityHashCode( a ) );
//        String s3 = a + new String( "s" );
//        System.out.println(System.identityHashCode( new String("123") + new String( "123" ) ));
//        String s3 = new String("123") + new String( "123" );
//        System.out.println(s3);
//        System.out.println(System.identityHashCode( s3 ));
//        System.out.println(System.identityHashCode( s3.intern() ));
//
//        System.out.println(System.identityHashCode( s3 ));
//        String s4 = "123123";
//        System.out.println(System.identityHashCode( s3 ));
//        System.out.println(System.identityHashCode( s4 ));
//        System.out.println(System.identityHashCode( s3.intern() ));
//        System.out.println(s3.intern() == s4);
//        System.out.println(s3 == s4);

//        String s5 = new String("1");
//        s5.intern();
//        String s6 = "1";
//        System.out.println(s5 == s6);
    }
}
