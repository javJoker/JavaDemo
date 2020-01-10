package com.self.jdk.java.basicType;

public class TestLong {
    public static void main(String[] args) {
        long i = 1L;
        System.out.println(Long.signum( i ));
//        System.out.println(Long.toBinaryString( i ));
//        System.out.println(Long.toBinaryString(Long.rotateLeft(i, 2)));
//        System.out.println(Long.toBinaryString(Long.rotateRight(i, 2)));
////        System.out.println(Long.reverse(i));
//        System.out.println(Long.toBinaryString( Long.reverse(i) ));

//        System.out.println(Long.parseUnsignedLong( "1111111111111111111111111111111100000000000000000000000000000000", 2 ));
//        System.out.println(Integer.MAX_VALUE);
//        long i = -4294967296L;
//        int ii = (int)i;
//        System.out.println(Long.toBinaryString( i ));
//        System.out.println(Long.toBinaryString( i ).length());
//        System.out.println(Long.toBinaryString( ii ));
////        System.out.println(ii);
//
////        System.out.println(Long.toBinaryString( 10L ));
//        System.out.println(Long.numberOfTrailingZeros( i ));

//        System.out.println(numberOfTrailingZeros(i));

//        System.out.println(Long.toBinaryString( 10L ));

//        testHighestOneBit();


//        test();

//
//        System.out.println(Long.divideUnsigned(q1, q2));

//        Temp temp1 = new Temp( 20 );
//        Temp temp2 = new Temp( 30 );
//        temp1.compare( temp2 );

//        Long i = Long.valueOf( 11111 );
//        System.out.println();

//        long i1 = 1299;
//        long i2 = 1299;
//        System.out.println(i1 == i2);
//        System.out.println(System.identityHashCode( i ));
//        System.out.println(System.identityHashCode( i2 ));
//        System.out.println(System.getProperties().toString());

//        int n = 2;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        System.out.println(n);
//        System.out.println(n >>> 2);

//        Long x = Long.valueOf( Long.MAX_VALUE );
//        System.out.println(x >>> 32);
//        System.out.println(x.shortValue());

//        System.out.println(-Long.MAX_VALUE);
//        result = negative ? Long.valueOf(-result.longValue()) : result;
//        System.out.println(Long.decode( "--0777" ));

//        testValueOf();

//        parseUnsignedLong("101011", 2);
    }

    public static int numberOfTrailingZeros(long i) {
        // HD, Figure 5-14
        int x, y;
        if (i == 0) return 64;
        int n = 63;
        // i为long类型，强制类型转化
        y = (int)i; if (y != 0) { n = n -32; x = y; } else x = (int)(i>>>32);
        System.out.println(y);
        y = x <<16; if (y != 0) { n = n -16; x = y; }
        System.out.println(y);
        y = x << 8; if (y != 0) { n = n - 8; x = y; }
        System.out.println(y);
        y = x << 4; if (y != 0) { n = n - 4; x = y; }
        System.out.println(y);
        y = x << 2; if (y != 0) { n = n - 2; x = y; }
        System.out.println(y);
        return n - ((x << 1) >>> 31);
    }

    private static void testHighestOneBit() {
        System.out.println(Long.toBinaryString( Long.MAX_VALUE ).length());
        System.out.println(Long.highestOneBit(Long.MAX_VALUE - 1 ));
        long i = Long.MAX_VALUE - 1;
        System.out.println("============================");
//        System.out.println(Long.toBinaryString( i >>  1 ));
        System.out.println(Long.toBinaryString( i |= (i >>  1) ));
        System.out.println(Long.toBinaryString( i |= (i >>  2) ));
        System.out.println(Long.toBinaryString( i |= (i >>  4) ));
        System.out.println(Long.toBinaryString( i |= (i >>  8) ));
        System.out.println(Long.toBinaryString( i |= (i >>  32) ));

        System.out.println(Long.toBinaryString( (i >>  1) ));
    }

    private static void test() {
        Long i1 = Long.valueOf( 127 );
        Long i2 = Long.valueOf( 127 );
        System.out.println(i1 == i2);
        System.out.println(i1.equals( i2 ));
        System.out.println("i1 内存：" + System.identityHashCode( i1 ));
        System.out.println("i2 内存：" + System.identityHashCode( i2 ));

        Long i3 = Long.valueOf( 1270 );
        Long i4 = Long.valueOf( 1270 );
        System.out.println(i3 == i4);
        System.out.println(i3.equals( i4 ));
        System.out.println("i3 内存：" + System.identityHashCode( i3 ));
        System.out.println("i4 内存：" + System.identityHashCode( i4 ));

        System.out.println(" ======== long 自动装箱 ============");
        long i5 = -129;
        long i6 = -129;
        System.out.println(i5 == i6);
        System.out.println("i5 内存：" +System.identityHashCode( i5 ));
        System.out.println("i6 内存：" +System.identityHashCode( i6 ));
    }

    private static void testValueOf() {
        Long q1 = Long.valueOf( 127 );
        Long q2 = Long.valueOf( 127 );
        System.out.println(q1.equals( q2 ));
        System.out.println(q1 == q2);

        Long i1 = Long.valueOf( 1299 );
        Long i2 = Long.valueOf( 1299 );
        System.out.println(i1.equals( i2 ));
        System.out.println(i1 == i2);

        Integer i3 = Integer.valueOf( 1279 );
        Integer i4 = Integer.valueOf( 1279 );
        System.out.println(i3.equals( i4 ));
        System.out.println(i3 == i4);
    }

    public static long parseUnsignedLong(String s, int radix)
            throws NumberFormatException {
        if (s == null)  {
            throw new NumberFormatException("null");
        }

        int len = s.length();
        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar == '-') {
                throw new
                        NumberFormatException(String.format("Illegal leading minus sign " +
                        "on unsigned string %s.", s));
            } else {
                // ??
//                if (len <= 12 || // Long.MAX_VALUE in Character.MAX_RADIX is 13 digits
//                        (radix == 10 && len <= 18) ) { // Long.MAX_VALUE in base 10 is 19 digits
//                    return Long.parseLong(s, radix);
//                }

                // No need for range checks on len due to testing above.
                long first = Long.parseLong(s.substring(0, len - 1), radix);
                int second = Character.digit(s.charAt(len - 1), radix);
                if (second < 0) {
                    throw new NumberFormatException("Bad digit at end of " + s);
                }
                long result = first * radix + second;
                if (Long.compareUnsigned(result, first) < 0) {
                    /*
                     * The maximum unsigned value, (2^64)-1, takes at
                     * most one more digit to represent than the
                     * maximum signed value, (2^63)-1.  Therefore,
                     * parsing (len - 1) digits will be appropriately
                     * in-range of the signed parsing.  In other
                     * words, if parsing (len -1) digits overflows
                     * signed parsing, parsing len digits will
                     * certainly overflow unsigned parsing.
                     *
                     * The compareUnsigned check above catches
                     * situations where an unsigned overflow occurs
                     * incorporating the contribution of the final
                     * digit.
                     */
                    throw new NumberFormatException(String.format("String value %s exceeds " +
                            "range of unsigned long.", s));
                }
                return result;
            }
        } else {
            System.out.println(11111111);
        }
        return 111;
    }
}

class Temp{
    private int value;

    Temp(int value) {
        this.value = value;
    }

    Temp() {
    }
    void compare(Temp temp){
        if (temp.value > 0 && this.value > 0){
            System.out.println(temp.value);
            System.out.println(this.value);
            System.out.println(111111);
        }
    }
}
