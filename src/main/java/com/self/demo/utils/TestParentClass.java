package com.self.demo.utils;

/**
 * 双亲委派
 * 先初始化父类，再初始化子类
 */
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
