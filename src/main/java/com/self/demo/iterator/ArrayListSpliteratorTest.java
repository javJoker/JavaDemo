package com.self.demo.iterator;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.regex.Pattern;

public class ArrayListSpliteratorTest {

    public static void main(String[] args) {
        test();
//        test2();
    }

    private static void test2() {
        List<String> strList = createList();
        long count = 0;
        long start = System.currentTimeMillis();
        for (String item : strList){
            if (isInteger(item)){
                int num = Integer.parseInt( item + "" );
                count += num;
                System.out.println("数值：" + num + "------");
            }
        }

        long time = System.currentTimeMillis() - start;
        System.out.println(count);
        System.out.println(time);
    }

    private static void test() {
        AtomicLong count = new AtomicLong(0);
        List<String> strList = createList();
        Spliterator spliterator = strList.spliterator();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 4; i++){
            new Thread(()->{
                String threadName = Thread.currentThread().getName();
                System.out.println("线程" + threadName + "开始运行---------");
                spliterator.trySplit().forEachRemaining( new Consumer() {
                    @Override
                    public void accept(Object o) {
                        if (isInteger((String)o)){
                            int num = Integer.parseInt( o + "" );
                            count.addAndGet( num );
                            System.out.println("数值：" + num + "------" + threadName);
//                            try {
//                                Thread.sleep( 2000 );
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
                        }
                    }
                } );
                System.out.println("线程" + threadName + "运行结束--------");
            }).start();
        }
//        try {
//            Thread.sleep( 15000 );
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        long time = System.currentTimeMillis() - start;
        System.out.println("结果为：" + count);
        System.out.println("时间为：" + time);
    }

    private static List<String> createList(){
        List<String> result = Lists.newArrayList();
        for (int i = 0; i < 10000; i++){
            if (i % 10 == 0){
                result.add( i + "" );
            }else {
                result.add( "aaa" );
            }
        }
        return result;
    }

    private static Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");
    public static boolean isInteger(String str){
        return NUMBER_PATTERN.matcher( str ).matches();
    }


}

