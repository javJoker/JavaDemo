package com.self.demo.utils;

import com.alibaba.fastjson.JSON;
import com.self.demo.model.Department;
import com.self.demo.model.User;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Object的Compare方法
 *
 * @author javaJoker
 */
public class ObjectCompare {
    public static void main(String[] args) {
        Department d1 = new Department( 1, "1" );
        Department d2 = new Department( 1, "1" );

        User u1 = new User( 1, d1 );
        User u2 = new User( 1, d2 );
        try {
//            Map<String, Object> compare = compare( d1, d2 );
            compare(u1, u2);
//            System.out.println(u1.equals( u2 ));
//            compare( new BigDecimal( 1 ), new BigDecimal( 1 ) );
//            compare( Boolean.FALSE, Boolean.TRUE );
            int i =1;
            int i2=2;
//            compare( i, i2 );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 不属于JavaBean自身属性
    public static <T> Map<String, Object> compare(T obj1, T Obj2) throws Exception {

//        System.out.println(obj1.getClass()+ ": " + obj1.getClass().isPrimitive());
//
//        System.out.println(isBaseType( obj1 ));
        Field[] fs = obj1.getClass().getDeclaredFields();
        for (Field f : fs) {
            String key = f.getName();
            f.setAccessible(true);
//            int i =1;
//            System.out.println(f.getType() + ": " + f.getType().isPrimitive());
//            System.out.println(i);
//            System.out.println(java.lang.Integer.class.getName());

            if (f.getType().getName().equals( "com.self.demo.model.Department" )){
                Object v1 = f.get(obj1);
                Object v2 = f.get(Obj2);
                compare( v1, v2 );
            }
            Object v1 = f.get(obj1);
            Object v2 = f.get(Obj2);
            System.out.println(v1);
            System.out.println(f.getName());
            System.out.println(isBaseType( v1));

            String s1 = JSON.toJSONString( v1 );
            String s2 = JSON.toJSONString( v2 );
//            System.out.println(s1.equals( s2 ));
//            System.out.println(s1+ ":" + s1.equals( s2 ));
//            if( !NOFIELDNAME.equals( key ) ){
//            }
        }
        return null;
    }


    /**
     * 判断object是否为基本类型
     * @param object
     * @return
     */
    public static boolean isBaseType(Object object) {
        Class className = object.getClass();
        if (className.equals( java.lang.Integer.class ) ||
                className.equals( java.lang.Byte.class ) ||
                className.equals( java.lang.Long.class ) ||
                className.equals( java.lang.Double.class ) ||
                className.equals( java.lang.Float.class ) ||
                className.equals( java.lang.Character.class ) ||
                className.equals( java.lang.Short.class ) ||
                className.equals( java.lang.Boolean.class )) {
            return true;
        }
        return false;
    }
}
