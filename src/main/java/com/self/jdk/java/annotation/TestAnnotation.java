package com.self.jdk.java.annotation;

import java.util.Arrays;

public class TestAnnotation {
    public static void main(String[] args) {
//        testFloatEquals();

//        testDoubleEquals();

//        testClassEquals();

//        testArraysEquals();

    }

    private static void testArraysEquals() {
        String[] s1 = new String[]{"1","2"};
        String[] s2 = new String[]{"1","2"};
        System.out.println( Arrays.equals( s1, s2 ));
    }

    private static void testClassEquals() {
        Person p1 = new Person("tom");
        Person p2 = new Person("tom");

        System.out.println(p1.equals( p2 ));
    }

    private static void testDoubleEquals() {
        double d1 = 0.0;
        double d2 = -0.0;
        System.out.println(" double == :"  + ( d1 == d2 ));
        System.out.println("double equals :" + ( Double.valueOf( d1 ).equals( d2 ) ));
        System.out.println("d1 : " + d1);
        System.out.println("d2 : " + d2);
    }

    private static void testFloatEquals() {
        float a1 = 0.0f;
        float a2 = -0.0f;
        System.out.println("float == : " + (a1 == a2));
        System.out.println("float equals : " + (Float.valueOf( a1 ).equals( Float.valueOf( a2 ) )));
        System.out.println("a1:" + Float.valueOf( a1 ));
        System.out.println("a2:" + Float.valueOf( a2 ));
    }
}

class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }
}
