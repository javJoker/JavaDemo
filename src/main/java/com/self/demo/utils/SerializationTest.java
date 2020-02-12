package com.self.demo.utils;

import java.io.*;

/**
 * @description:
 * @author: JavJoker
 * @date: Created in 2020/2/12 19:51
 * @version: v1.0
 * @modified By:
 */
public class SerializationTest {
    public static void main(String[] args) throws Exception {
        User1 user1 = new User1();
        user1.setName("aaaa");
        user1.setUserId("11111");

        serializer(user1);
//        User1 derializer1 = derializer1();
//        System.out.println(derializer1.toString());
        User2 derializer2 = derializer2();


    }

    /**序列化对象*/
    private static void serializer(User1 user)throws Exception{
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(new File("./user.txt")));
        outputStream.writeObject(user);
        outputStream.close();
    }

    /**反序列化对象*/
    private static User1 derializer1()throws Exception{
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("./user.txt")));
        User1 user = (User1) inputStream.readObject();
        inputStream.close();
        return user;
    }

    /**反序列化对象*/
    private static User2 derializer2()throws Exception{
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("./user.txt")));
        User2 user = (User2) inputStream.readObject();
        inputStream.close();
        return user;
    }


}

class User1 implements Serializable{

    private static final long serialVersionUID = -6581730668636031546L;

    private String name;
    private String userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}

class User2 implements Serializable{
    private static final long serialVersionUID = 4671035546815002230L;

    private String name;
    private String userId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}

