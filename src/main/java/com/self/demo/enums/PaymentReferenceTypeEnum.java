package com.self.demo.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
* @Description: 付款申请单关联类型枚举
* @Author: javaJoker
* @Version: 1.0
*/
public enum PaymentReferenceTypeEnum {

    GCL(10, "工程量清单号"),
    QZ(20, "签证"),
    JC(30, "奖惩"),
    YZCD(40, "预支冲抵明细"),
    ;

    private int code;
    private String msg;

    // 静态初始化
    public static final Map<Integer, String> enumMap = new HashMap();
    static {
        Arrays.stream( PaymentReferenceTypeEnum.values() ).forEach( e -> System.out.println(e.getCode() + ":" + e.getMsg()) );
        Arrays.stream( PaymentReferenceTypeEnum.values() ).forEach( e -> enumMap.put( e.code, e.getMsg() ) );
    }

    public static String getMsgByCode(int code){
        return enumMap.get( code );
    }

    PaymentReferenceTypeEnum() {
    }

    PaymentReferenceTypeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

class TestEnum {
    public static void main(String[] args) {
        System.out.println(PaymentReferenceTypeEnum.getMsgByCode( 10 ));
    }
}


