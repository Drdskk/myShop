package com.cql.config;


import java.text.SimpleDateFormat;
import java.util.Date;

public class MyCurrentTime {

    public static String getTime(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
