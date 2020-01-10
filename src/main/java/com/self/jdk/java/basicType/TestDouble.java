package com.self.jdk.java.basicType;

public class TestDouble {
    public static void main(String[] args) {

        String[] temp = {"1", "2", "3"};
        System.out.println(temp + "");

//        test0();

//        test1();

//        test2();

//        test3();

//        System.out.println(Double.doubleToLongBits(1.0d ));
//        System.out.println(0x7ff8000000000000L);
//        System.out.println(-0.0d == +0.0d );
//        System.out.println(Double.min( -1.0d, +0.0d ));
//        System.out.println(Double.doubleToRawLongBits(0.0d) == Double.doubleToRawLongBits(-0.0d));

//        System.out.println(Math.min( new Double(null), Double.valueOf( -0.0d ) ));

    }

    private static void test3() {
        double d = 0.2d;
        Double d2 = Double.valueOf( d );
        Double d3 = Double.valueOf( d );

        System.out.println(System.identityHashCode( d2 ));
        System.out.println(System.identityHashCode( d3 ));
    }

    private static void test2() {
        String a = "100d";
        String b = "100d";
        System.out.println(Double.valueOf(a)==Double.valueOf(b));
        System.out.println(Double.valueOf(a).equals( Double.valueOf(b) ));
        System.out.println(Double.parseDouble(a)==Double.parseDouble(b));
    }

    private static void test0() {
        System.out.println(Double.POSITIVE_INFINITY);
        System.out.println(Double.NEGATIVE_INFINITY);
        System.out.println(Double.NaN);
        System.out.println(Double.MAX_VALUE);

        System.out.println(  Math.getExponent(Double.MIN_NORMAL) );
        System.out.println(0x1);
//        System.out.println(Double.longBitsToDouble());
    }

    private static void test1() {
        System.out.println(0.1f);
        System.out.println(0.1d);
        System.out.println(0.1f == 0.1d);

        System.out.println(Double.valueOf( "0.1f" ).equals( 0.1f ));
        System.out.println(Double.valueOf( "0.1f" ).equals( 0.1d ));
        System.out.println(Double.valueOf( "0.1f" ).equals( Double.valueOf( 0.1d )));
    }
}
