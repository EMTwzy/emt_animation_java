package com.emt_animation_java.www.utils;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class timeUtils {
    static long[] weekTime=new long[15];

    public static long[] time_utils() {
        int i=getTodayNum();
        LocalDate local=LocalDate.now();
        long l= getDateTime(local);
        weekTime[i+6]=l;
        //首先填补今天以前的数据
        for (int j = 0; j < i+6; j++) {
            weekTime[j]=l-(i+6-j)*86400;
        }
        //填补今天往后的数据
        for (int j = i+7; j <15 ; j++) {
            weekTime[j]=l+(j-i-6)*86400;
        }

        return weekTime;
    }

    //解析当前时间，获知当前是星期几
    public static int getTodayNum(){
        LocalDate date = LocalDate.now(); // 获取当前日期
        //System.out.println("this date is \t"+date);
        DayOfWeek dayOfWeek = date.getDayOfWeek(); // 获取当前星期
        //System.out.println("今天是" + dayOfWeek.getValue()); // 输出"今天是星期几"
        return dayOfWeek.getValue();
    }
    //将时间转换为时间戳
    public static long getDateTime(LocalDate date){
        LocalDate targetDate = date;
        // 将 LocalDate 转换为 Instant
        Instant instant = targetDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        // 获取时间戳（秒数）
        long timestamp = instant.getEpochSecond();
        return timestamp;
    }


}
