package com.self.demo.collections;

import com.alibaba.fastjson.JSON;
import com.self.demo.model.Department;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
* @Description: ArrayList测试类
* @Author: javaJoker
* @CreateDate: 2020/1/13 8:33
* @Version: 1.0
*/
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Department> a = new ArrayList();
        Department d1 = new Department();
        d1.setId(1);
        d1.setDeptName("111");
        a.add(d1);

        ArrayList<Department> clone = (ArrayList<Department>)a.clone();
        d1.setDeptName("22222");
        System.out.println(JSON.toJSON(a));
        System.out.println(JSON.toJSON(clone));

//        test1();

    }

    /**
     * ArrayList初始化的时候即使设置了初始容量大小，但是不会设置size的值，
     * set会有一个index和size大小校验，如果index大于size会抛出异常，
     * 只能通过add方法改变size的值，初始容量只是改变了在初始数组对象加了一个大小
     * 无设置容量大小会设置一个默认的EMPTY_ELEMENTDATA空对象数组
     */
    private static void test1() {
        ArrayList a = new ArrayList( 10 );
//        a.set( 2, 2 );

        Object[] obj = new Object[10];
        Consumer c = System.out::println;
        obj[1] = "1111";
        c.accept( obj[1] );
    }


}
