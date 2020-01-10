package com.self.demo;

import java.time.LocalDateTime;

public class TestLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime dateTime1 = LocalDateTime.of( 2019,9,2,2,2 );
        LocalDateTime dateTime2 = LocalDateTime.of( 2019,9,2,2,2 );
        System.out.println(dateTime1.isBefore( dateTime2 ) || dateTime1.isEqual( dateTime2 ));
        System.out.println(dateTime1.compareTo( dateTime2 ));
        System.out.println();
    }
}
 