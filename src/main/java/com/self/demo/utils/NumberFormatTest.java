package com.self.demo.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 *
 * @author javaJoker
 */
public class NumberFormatTest {

    public static void main(String[] args) {
        //待测试数据
        int i = 100;
        String str = "100";
        Double d = new Double( 2.2 );
        BigDecimal b = new BigDecimal( 2 );
//        System.out.println(i.);

        Object obj = str;
        System.out.println(obj.getClass().getName());
//        if (i instanceof Number){
//            System.out.println(1111);
//        }
        //得到一个NumberFormat的实例
        NumberFormat nf = NumberFormat.getInstance();
        //设置是否使用分组
//        nf.setGroupingUsed(true);
        //设置最大整数位数
        nf.setMaximumIntegerDigits(6);
        //设置最小整数位数    
        nf.setMinimumIntegerDigits(4);
        //输出测试语句
        System.out.println(nf.format(obj));
    }
}