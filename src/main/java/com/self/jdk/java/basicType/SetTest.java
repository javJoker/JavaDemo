package com.self.jdk.java.basicType;

import java.math.BigDecimal;
import java.util.HashSet;

public class SetTest {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        BigDecimal d1 = new BigDecimal( "1.0" );
        BigDecimal d3 = new BigDecimal( "1.0" );
        System.out.println(System.identityHashCode( d1 ));
        System.out.println(System.identityHashCode( d3 ));
        BigDecimal d2 = new BigDecimal( "1.00" );
        d1.equals( d3 );
        set.add( d1 );
        set.add( d2 );
        System.out.println(set.size());
    }
}
