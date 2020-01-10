package com.self.demo;

import java.util.ArrayList;
import java.util.function.Consumer;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList a = new ArrayList( 10 );
        a.set( 2, 2 );

        Object[] obj = new Object[10];
        Consumer c = System.out::println;
        obj[1] = "1111";
        c.accept( obj[1] );

    }
}
