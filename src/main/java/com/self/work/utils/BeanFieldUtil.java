package com.self.work.utils;

import org.apache.commons.lang3.StringUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
* @Description: Bean工具类
* @Author: DeYi Peng
* @CreateDate: 2019/11/12 17:10
* @Version: 1.0
*/
public class BeanFieldUtil {

    /**
     * 字段翻译，需要翻译的主体可以是集合、Map、对象数组、对象
     * @param source 需要翻译的主体
     * @param sourceFiled 需要翻译的字段
     * @param targetFiled 翻译后存取的字段
     * @param translateList 翻译集合（对象List）
     * @param traSourceFiled 翻译的key
     * @param traTargetFiled 翻译的value
     * @param <T>
     * @param <E>
     */
    public static<T, E> void fieldTranslate(T source, String sourceFiled, String targetFiled,
                                            List<E> translateList, String traSourceFiled, String traTargetFiled){
        // 判断需要翻译是集合还是对象
        if (source instanceof Collection){
            for (Object obj : ((Collection) source)) {
                setSourceValue(obj, sourceFiled, targetFiled, translateList, traSourceFiled, traTargetFiled );
            }
        }else if (source instanceof Map){
            Map sourceMap = (Map) source;
            Iterator<Map.Entry<Object, Object>> entries = sourceMap.entrySet().iterator();
            while(entries.hasNext()){
                Map.Entry<Object, Object> entry = entries.next();
                Object key = entry.getKey();
                Object value = entry.getValue();

                setSourceValue(value, sourceFiled, targetFiled, translateList, traSourceFiled, traTargetFiled );
                sourceMap.put( key, value );

            }
        }else if (source.getClass().isArray()){
            Object[] sourceArr = (Object[]) source;
            for (int i=0; i < sourceArr.length; i++){
                Object obj = sourceArr[i];
                setSourceValue(obj, sourceFiled, targetFiled, translateList, traSourceFiled, traTargetFiled );
            }
        }else {
            setSourceValue(source, sourceFiled, targetFiled, translateList, traSourceFiled, traTargetFiled );
        }
    }

    /**
     * 对象翻译
     * @param source 翻译对象
     * @param sourceFiled 需要翻译的字段
     * @param targetFiled 翻译后存取的字段
     * @param translateList 翻译集合（对象List）
     * @param traSourceFiled 翻译的key
     * @param traTargetFiled 翻译的value
     * @param <E>
     */
    private static<E> void setSourceValue(Object source, String sourceFiled, String targetFiled,
                                          List<E> translateList, String traSourceFiled, String traTargetFiled ){
        Object sourceValue = getValueOfGet( source, sourceFiled );
        for (E item : translateList){
            Object traSourceValue = getValueOfGet( item, traSourceFiled );
            if (Objects.equals( sourceValue, traSourceValue )){
                Object traTargetValue = getValueOfGet( item, traTargetFiled );
                setValueOfSet(source, targetFiled, traTargetValue);
            }
        }
    }

    /**
     * 通过字段名从对象或对象的父类中得到字段的值（调用对象的get方法）
     * @param object 对象实例
     * @param fieldName 字段名
     * @return 字段对应的值
     */
    public static Object getValueOfGet(Object object, String fieldName){
        // 对象为空
        if (object == null) {
            return null;
        }

        // 字段名为空
        if (StringUtils.isBlank(fieldName)) {
            return null;
        }

        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);

                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                //获得get方法
                Method getMethod = pd.getReadMethod();
                //执行get方法返回一个Object
                return getMethod.invoke(object);
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
            }
        }
        return null;
    }

    /**
     * 通过字段名存取值（调用对象的set方法）
     * @param object 对象实例
     * @param fieldName 字段名
     * @param fieldName 存值
     * @return 字段对应的值
     */
    public static Object setValueOfSet(Object object, String fieldName, Object value) {
        // 对象为空
        if (object == null) {
            return null;
        }

        // 字段名为空
        if (StringUtils.isBlank(fieldName)) {
            return null;
        }

        // 存取的值为空（无对应的翻译）
        if (Objects.isNull(value)) {
            return null;
        }

        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);

                PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                //获得set方法
                Method setMethod = pd.getWriteMethod();
                //执行set方法返回一个Object
                return setMethod.invoke(object, value);
            } catch (Exception e) {
                //这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
                //如果这里的异常打印或者往外抛，则就不会执行clazz = clazz.getSuperclass(),最后就不会进入到父类中了
            }
        }
        return null;
    }


    /**
     * 判断对象内部的属性是否为空的方法
     * @param obj           要判断的对象实例
     * @param exclField      不需要做判断的属性
     * @return
     */
    public static<T>  boolean validateField(T obj, Set<String> exclField) {

        boolean target = false;
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field f : declaredFields) {
            f.setAccessible(true);
            try {
                String name = f.getName();
                // 判断属性名称是否在排除属性值中
                if (!exclField.contains(name) && f.get(obj) == null) {
                    // 判断字段是否为空，并且对象属性中的基本都会转为对象类型来判断
                    target = true;

                }
            }catch (Exception e) {
                e.printStackTrace();
                throw new IllegalArgumentException( "对象属性解析异常" + e.getMessage() );
            }
        }
        return target;
    }

    /**
     * 判断对象的所有属性是否都为空
     * @param obj           要判断的对象实例
     * @return
     */
    public static<T>  boolean isEmptyAllField(T obj) {
        int isEmptyField = 0;
        boolean target = false;
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        int length = declaredFields.length;
        // 属性为空
        if (length < 1){
            return target;
        }
        for (Field f : declaredFields) {
            f.setAccessible(true);
            try {
                if (Objects.isNull( f.get(obj) )) {
                    isEmptyField++;
                }
            }catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new IllegalArgumentException( "对象属性解析异常" + e.getMessage() );
            }
        }

        if (length == isEmptyField){
            target = true;
        }

        return target;
    }

    /**
     * 判断对象的所有属性是否都为空
     * @param obj           要判断的对象实例
     * @return
     */
    /**
     * 判断对象的所有属性是否都为空
     * @param obj 要判断的对象实例
     * @param exclField 不需要做判断的属性
     * @return
     */
    public static<T>  boolean isEmptyAllField(T obj, Set<String> exclField) {
        int isEmptyField = 0;
        boolean target = false;
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        int length = declaredFields.length;
        // 属性为空
        if (length < 1){
            return target;
        }
        for (Field f : declaredFields) {
            f.setAccessible(true);
            try {
                String name = f.getName();
                // 判断属性名称是否在排除属性值中
                if (!exclField.contains(name) && Objects.isNull( f.get(obj) )) {
                    isEmptyField++;
                }
            }catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new IllegalArgumentException( "对象属性解析异常" + e.getMessage() );
            }
        }

        int size = exclField.size();
        if ((length - size) == isEmptyField){
            target = true;
        }

        return target;
    }

}
