package com.self.demo;

public class TestParentClass extends Parent {
    public static void main(String[] args) {
        new TestParentClass();
    }

    TestParentClass(){
        this.sayHello();
    }
}

class Parent {
    Parent(){
        System.out.println("parent");
    }

    public void sayHello(){
        System.out.println("hello, parent");
    }
}
