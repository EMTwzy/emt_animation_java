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
        long l= getDateTime(String.valueOf(local));
        //首先填补前天以前的数据
        for (int j = 0; j < i+6; j++) {
            weekTime[j]=l-(i+6-j)*86400;
        }
        weekTime[i+6]=l;
        //填补今天往后的数据
        for (int j = i+7; j <15 ; j++) {
            weekTime[j]=l+(j-i-6)*86400;
        }
        /*int a=0;
        for (long l1 : weekTime) {
            System.out.print("   星期"+(a+1)+":"+l1);
            a++;
            if(a==7){
                System.out.println();
                a=0;
            }
        }
        System.out.println("\t\t今天是"+i+"\t时间"+l);*/
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
    public static long getDateTime(String date){
        // 目标日期字符串
        String targetDateStr = date;
        // 将目标日期字符串解析为 LocalDate 对象
        LocalDate targetDate = LocalDate.parse(targetDateStr);
        // 将 LocalDate 转换为 Instant
        Instant instant = targetDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
        // 获取时间戳（秒数）
        long timestamp = instant.getEpochSecond();
        //System.out.println("目标日期：" + targetDateStr);
        //System.out.println("转换后的时间戳：" + timestamp);
        return timestamp;
    }


}
