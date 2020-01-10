package com.self.jdk.java.basicType;

public class TestByte {
    public static void main(String[] args) {
        byte a = 127;
        byte b = 127;
        a += b;
        System.out.println(a);

        byte c = 127;
        byte d = 127;
        a = (byte) (a + b);
        System.out.println(a);
    }
}
