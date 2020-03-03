package com.self.demo.collections;

import com.alibaba.fastjson.JSON;
import com.self.demo.model.Department;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

/**
* @Description: ArrayList测试类
* @Author: javaJoker
* @CreateDate: 2020/1/13 8:33
* @Version: 1.0
*/
public class ArrayListTest {
    public static void main(String[] args) {
//        test2();

        test1();

    }

    /**
     * 测试ArrayList.clone()是否为深拷贝还浅拷贝
     * java中是否有深拷贝，如果我们希望深拷贝对象中的对象的话，需要我们自己实现Cloneable接口，
     * 重写Object中的clone方法，见{@link com.self.demo.model.Department}
     *
     * ArrayList.clone()为浅拷贝，深拷贝需要自己实现
     */
    private static void test2() {
        ArrayList<Department> a = new ArrayList();
        Department d1 = new Department();
        d1.setId(1);
        d1.setDeptName("111");
        a.add(d1);

        // 浅拷贝
        System.out.println("=====================");
        ArrayList<Department> clone = (ArrayList<Department>)a.clone();
        d1.setDeptName("22222");
        System.out.println(JSON.toJSON(a));
        System.out.println(JSON.toJSON(clone));

        // 深拷贝
        ArrayList<Department> deepClone = new ArrayList();

        //重新new对象加入新集合
        for (Department temp : a) {
            try {
                deepClone.add((Department)temp.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("=====================");
        d1.setDeptName("3333");
        System.out.println(JSON.toJSON(a));
        System.out.println(JSON.toJSON(clone));
        System.out.println(JSON.toJSON(deepClone));

        // 通过字节流进行copy
        ArrayList<Department> streamClone = new ArrayList();

        for (Department temp : a) {
            streamClone.add(CloneUtils.clone(temp));
        }

        System.out.println("=====================");
        d1.setDeptName("444");
        System.out.println(JSON.toJSON(a));
        System.out.println(JSON.toJSON(clone));
        System.out.println(JSON.toJSON(deepClone));
        System.out.println(JSON.toJSON(streamClone));

    }

    /**
     * ArrayList初始化的时候即使设置了初始容量大小，但是不会设置size的值，
     * set会有一个index和size大小校验，如果index大于size会抛出异常，
     * 只能通过add方法改变size的值，初始容量只是改变了在初始数组对象加了一个大小
     * 无设置容量大小会设置一个默认的EMPTY_ELEMENTDATA空对象数组。
     */
    private static void test1() {
        ArrayList a = new ArrayList( 10 );
//        a.set( 2, 2 );

        Object[] obj = new Object[10];
        String[] obj1 = new String[10];
        Consumer c = System.out::println;
        obj[1] = "1111";
        c.accept( obj[1] );
        c.accept(String[].class);

    }
}

/**
 * 通过字节流序列化实现深拷贝，需要深拷贝的对象必须实现Serializable接口
 *
 */
class CloneUtils {
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj) {
        T cloneObj = null;
        try {
            // 写入字节流
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(obj);
            obs.close();

            // 分配内存，写入原始对象，生成新对象
            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(ios);
            // 返回生成的新对象
            cloneObj = (T) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cloneObj;
    }
}

