package com.self.demo.pattern.builder;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Description: TODO
 * @Author javaJoker
 * @Date 2020/3/11
 * @Version V1.0
 **/
public class GirlFriend {
    private String name;
    private int age;
    private int bust;
    private int waist;
    private int hips;
    private List<String> hobby;
    private String birthday;
    private String address;
    private String mobile;
    private String email;
    private String haireColor;
    private Map<String, String> gift;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBust() {
        return bust;
    }

    public void setBust(int bust) {
        this.bust = bust;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    public int getHips() {
        return hips;
    }

    public void setHips(int hips) {
        this.hips = hips;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaireColor() {
        return haireColor;
    }

    public void setHaireColor(String haireColor) {
        this.haireColor = haireColor;
    }

    public Map<String, String> getGift() {
        return gift;
    }

    public void setGift(Map<String, String> gift) {
        this.gift = gift;
    }

    // 为了掩饰方便，加几个聚合方法
    public void addHobby(String hobby){
        this.hobby = Optional.ofNullable( this.hobby ).orElse( Lists.newArrayList() );
        this.hobby.add( hobby );
    }

    public void addGift(String day, String gift){
        this.gift = Optional.ofNullable( this.gift ).orElse( Maps.newHashMap() );
        this.gift.put( day, gift );
    }

    public void setVitalStatistics(int bust, int waist, int hips){
        this.bust = bust;
        this.waist = waist;
        this.hips = hips;
    }

    public static void main(String[] args) {
//        GirlFriend girlFriend = new GirlFriend();
//        girlFriend.setName( "小妹" );
//        girlFriend.setAge( 18 );
//        girlFriend.setBust( 33 );
//        girlFriend.setWaist( 23 );
//        girlFriend.setHips( 33 );
//        girlFriend.setBirthday( "2001-03-03" );
//        girlFriend.setAddress( "上海" );
//        girlFriend.setMobile( "1331344578" );
//        girlFriend.setEmail( "1231@qq.com" );
//        List<String> hobby = Lists.newArrayList();
//        hobby.add( "逛街 " );
//        hobby.add( "购物" );
//        girlFriend.setHobby( hobby );
//        Map<String, String> gift = Maps.newHashMap();
//        gift.put( "a", "a" );
//        gift.put( "a1", "a1" );
//        gift.put( "a2", "a2" );
//        girlFriend.setGift( gift );

        GirlFriend girlFriend = Builder.of( GirlFriend::new )
                .with( GirlFriend::setName, "小妹" )
                .with( GirlFriend::setAge, 18 )
                .with( GirlFriend::setVitalStatistics, 33, 23, 33 )
                .with( GirlFriend::setBirthday, "2002-03-03" )
                .with( GirlFriend::setAddress, "上海" )
                .with( GirlFriend::setMobile, "13312312312" )
                .with( GirlFriend::setEmail, "11111@qq.com" )
                .with( GirlFriend::setHaireColor, "red" )
                .with( GirlFriend::addHobby, "购物" )
                .with( GirlFriend::addHobby, "脉动" )
                .with( GirlFriend::addGift, "a", "a" )
                .with( GirlFriend::addGift, "ac", "ac" )
                .with( GirlFriend::addGift, "aa", "aa" )
                .with( GirlFriend::addGift, "c", "c" )
                .builder();
        System.out.println(girlFriend);
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", bust=" + bust +
                ", waist=" + waist +
                ", hips=" + hips +
                ", hobby=" + hobby +
                ", birthday='" + birthday + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", haireColor='" + haireColor + '\'' +
                ", gift=" + gift +
                '}';
    }
}
