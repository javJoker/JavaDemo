package com.self.demo.clazz;

import java.lang.reflect.Constructor;

/**
 * 单例测试用例
 */
public class SingletonClassTest {
    public static void main(String[] args) {
//        RecycleBinHungryMan.getInstance();

//        testHungryMan1();
    }

    private static void testHungryMan1() {
        try {
            Class<?> clazz = RecycleBinHungryMan.class;
            // 通过反射，拿到构造方法
            Constructor c = clazz.getDeclaredConstructor();
            c.setAccessible( true );
            // 第一次初始化
            Object o1 = c.newInstance();
            // 调用第二次构造方法，相当于new了两次
            // 如果RecycleBinHungryMan构造方法没有LazyHolder.recycle进行校验的话，可能会多次重复创建
            Object o2 = c.newInstance();
            System.out.println(o1 == o2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * 利用静态内部类实现饿汉式
 * ----- 优点：
 * 1.节省了空间，不是外部类初始化的时候就初始化
 * 2.内部类一定是在方法调用之前初始化，巧妙的避免了线程安全问题
 *
 * 静态内部类初始化是在调用的时候才初始化，和外部静态代码块、静态常量、静态方法不一样
 * 静态内部类初始化可以看博客：https://blog.csdn.net/zhang_yanye/article/details/50344447
 */
class RecycleBinHungryMan{
    // 构造方法初始化
    private RecycleBinHungryMan(){
        // 防止多次重复创建
        if (LazyHolder.recycle != null){
            throw new RuntimeException( "不能重复初始化！" );
        }
    }

    public static final RecycleBinHungryMan getInstance(){
        return LazyHolder.recycle;
    }

    private static class LazyHolder{
        private static final RecycleBinHungryMan recycle = new RecycleBinHungryMan();
    }
}

/**
 * 双重校验 懒汉
 */
class RecycleBinLazyMan{
    private volatile static RecycleBinLazyMan recycle;

    private RecycleBinLazyMan(){}

    public static RecycleBinLazyMan getInstance(){
        if (recycle == null){
            synchronized (RecycleBinLazyMan.class){
                if (recycle == null){
                    recycle = new RecycleBinLazyMan();
                }
            }
        }
        return recycle;
    }
}


