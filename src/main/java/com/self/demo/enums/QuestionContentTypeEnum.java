package com.self.demo.enums;


import org.apache.commons.lang3.StringUtils;

import java.util.function.Consumer;

/**
 * @Description: 枚举顺序显示
 * @Author: javaJoker
 * @CreateDate: 2019/12/17 17:06
 * @Version: 1.0
 */
public enum QuestionContentTypeEnum {

    // 注意这个顺序会影响前端展示题目的顺序，不要轻易改变顺序
    DAX("DAX", "单选"),
    DUX("DUX", "多选"),
    PD("PD", "判断"),
    TK("TK", "填空"),
    JD("JD", "简单"),
    ;
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    QuestionContentTypeEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public static QuestionContentTypeEnum getMsgByCode(String code){
        if (StringUtils.isBlank( code )){
            return null;
        }

        for (QuestionContentTypeEnum item : QuestionContentTypeEnum.values()){
            if (item.code.equals( code )){
                return item;
            }
        }

        return null;
    }

}

class TestEnum1{
    public static void main(String[] args) {
        // 顺序显示
        for (QuestionContentTypeEnum enumItem : QuestionContentTypeEnum.values()){
            Consumer c = System.out::println;
            c.accept( enumItem.getMsg() );
        }
    }
}
