package com.self.demo;

import java.util.ArrayList;
import java.util.List;

public class GenericTypes{
    public static void main(String[] args) {
        Integer a=1;
        Integer b=2;
        Integer c=3;
        Integer d=3;
        Integer d1= new Integer( 3 );
        Integer e=321;
        System.out.println(Integer.MAX_VALUE);
        Integer f=321;
        Long g=3L;
        System.out.println(d == d1);
        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));
    }
//    public static String method(List<String> list){
//        System.out.println("invoke method(List<String>list)");
//            return"";
//    }
//    public static int method(List<Integer>list){
//        System.out.println("invoke method(List<Integer>list)");
//        return 1;
//    }
//    public static void main(String[]args){
//        method(new ArrayList<String>());
//        method(new ArrayList<Integer>());
//    }
//
//    public int test(List<String> list){
//        return 1;
//    }
//
//    public String test(List<Integer> list){
//        return null;
//    }
}