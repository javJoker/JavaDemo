package com.self.demo.pattern.single;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description: 单例模式
 * @Author javaJoker
 * @Date 2020/3/11
 * @Version V1.0
 **/
public class Singleton {
    private static final AtomicReference<Singleton> INSTANCE = new AtomicReference<Singleton>();

    private Singleton(){}

    public static Singleton getInstance(){
        for (;;){
            Singleton singleton = INSTANCE.get();
            if (null != singleton){
                return singleton;
            }

            singleton = new Singleton();
            if (INSTANCE.compareAndSet( null, singleton )){
                return singleton;
            }
        }
    }

    // test
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1 == instance2);
    }
}
