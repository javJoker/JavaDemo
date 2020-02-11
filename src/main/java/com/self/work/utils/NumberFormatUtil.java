package com.self.work.utils;


//import org.apache.log4j.Logger;

import java.text.NumberFormat;

/**
* @Description: 数字格式化工具类
* @Author: DeYi Peng
* @CreateDate: 2019/6/4 14:21
* @Version: 1.0
*/
public class NumberFormatUtil {

//    private static Logger logger = Logger.getLogger(NumberFormatUtil.class);

    /**
     * 自动补齐位数，以0补充。当整数
     * @param number 需要填充的数值
     * @param isGroupingUsed 是否分组（例如：1,000），true为分组，false为不分组,
     * @param maxNum  最大位数
     * @param minNum  最小位数
     * @return
     */
    public static String fillNumberPlace(Object number, Boolean isGroupingUsed, Integer maxNum, Integer minNum) throws Exception{

        if (maxNum != null && minNum != null && minNum.compareTo( maxNum ) > 0) {
//            logger.error( "最小位数大于最大位数值！" );
            throw new Exception( "最小位数大于最大位数值！" );
        }

        //得到一个NumberFormat的实例
        NumberFormat nf = NumberFormat.getInstance();

        //设置是否使用分组
        nf.setGroupingUsed(isGroupingUsed);

        if (minNum != null) {
            //设置最小整数位数
            nf.setMinimumIntegerDigits(minNum);
        }

        if (maxNum != null) {
            //设置最大整数位数
            nf.setMaximumIntegerDigits(maxNum);
        }

        String format = null;
        try {
            format = nf.format( number );
        } catch (IllegalArgumentException e) {
//            logger.error( "number参数非数值型的！" + e.getMessage() );
            throw new Exception( "number参数非数值型的！" , e);
        }

        return format;


    }
}
