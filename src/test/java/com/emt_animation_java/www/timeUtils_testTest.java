package com.emt_animation_java.www;
import org.junit.Test;
import java.time.*;



public class timeUtils_testTest {
    long[] weekTime=new long[15];
    int startMonth,startYear,startDay;//初始年份、初始月份、初始日期

    @Test
    public void time_utils() {
        String weekStart=getWeekTime();       //获取今天的日期，并且填充今天的时间戳
        System.out.println("上周的第一天的日期为"+weekStart);

        fullWeekTime();  //填充其余天的时间戳
        for (long l : weekTime) {
            System.out.print(l+"\t");
        }
    }
    @Test
    public void time_utils2(){
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
        int a=0;
        for (long l1 : weekTime) {
            System.out.print("   星期"+(a+1)+":"+l1);
            a++;
            if(a==7){
                System.out.println();
                a=0;
            }
        }
        System.out.println("\t\t今天是"+i+"\t时间"+l);
    }

    //解析当前时间，获知当前是星期几
    public int getTodayNum(){
        LocalDate date = LocalDate.now(); // 获取当前日期
        DayOfWeek dayOfWeek = date.getDayOfWeek(); // 获取当前星期数
        return dayOfWeek.getValue();
    }

    //填充除了当天和本周第一、最后一天以外的时间戳
    public void fullWeekTime(){
        int nowDay=getTodayNum();
        LocalDate local=LocalDate.now();
        int MonthDay=local.getDayOfMonth();  //获取今日的日期
        //填充其他几天的时间戳
        int monthTD=getBeforeMonth(local.getMonthValue());   //当月的总天数
        int month=startMonth;
        int year=startYear;
        int weekDay;
        for (int i = 1; i < nowDay-1; i++) {
            weekDay=startDay+i;
            if(weekDay>monthTD){
                int subDay=weekDay-monthTD;  //计算到底超出了多少天
                month++;
                if(month>12){
                    month=1;
                    year++;
                }
                weekDay=subDay;
            }
            String thisDay=String.format("%d-%02d-%02d",year,month,weekDay);
            weekTime[i+7]=getDateTime(thisDay);
        }
        for (int i = nowDay; i < 7; i++) {
            weekDay=local.getDayOfMonth()+(i-nowDay)+1;
            if(weekDay>monthTD){
                int subDay=weekDay-monthTD;
                month=local.getMonthValue()+1;
                if(month>12){
                    month++;
                    year=local.getYear()+1;
                }
                weekDay=subDay;
            }
            String thisDay=String.format("%d-%02d-%02d", year,month,weekDay);
            weekTime[i+7]=getDateTime(thisDay);
        }
        weekTime[14]=weekTime[13]+86400;
        for(int i=0;i<7;i++){
            weekTime[i]=weekTime[i+7]-604800;
        }
    }

    //获取本周第一天的时间戳
    public String getWeekTime(){
        //首先获取当前时间的星期几
        int nowDay=getTodayNum();
        LocalDate local=LocalDate.now();
        //将今日的时间戳注入数组
        weekTime[nowDay-1+7]=getDateTime(String.valueOf(local));

        startMonth=local.getMonthValue();
        startYear=local.getYear();
        //获知今天是这个月的第几天    用当前所处月日数-星期数  5-2+1
        startDay=local.getDayOfMonth()-nowDay+1;
        /**
         * 假设向后推的过程中月份以及年份皆未出现变化
         * **/
        //拼接本周第一天的标准时间量
        String weekStart=String.format("%d-%02d-%02d", startYear, startMonth, startDay);;
        /**
         * 假设 2023.3.2 为星期5 即再向前推的过程中出现了月份的变更
         * 此过程中年份没有变动
         * **/
        if (local.getDayOfMonth()<nowDay){
            startMonth=startMonth-1;
            /***
             * 假设 2023.1.1 为星期5 即再向前推的过程中年份也发生了变动
             * 年份发生变动的前提是月份也发生了变动
             * */
            if(startMonth==0){   //1月前推为0
                startMonth=12;
                startYear=startYear-1;
                startDay=31-(nowDay-local.getDayOfMonth());  //12月的31天-（今日的星期数-今日的日期数)
                weekStart=String.format("%d-%02d-%02d", startYear, startMonth, startDay);
                weekTime[7]=getDateTime(weekStart);
                return weekStart;
            }else{
                //年份没变
                startDay=getBeforeMonth(startMonth)-(nowDay-local.getDayOfMonth());//上个月的总天数-（今日的星期数-今日的日期）
                weekStart=String.format("%d-%02d-%02d", startYear, startMonth, startDay);
                weekTime[7]=getDateTime(weekStart);
                return weekStart;
            }
        }
        weekTime[7]=getDateTime(weekStart);
        System.out.println(weekStart instanceof String);
        return weekStart;
    }

    //获取到月份后 返回该月份的日期数
    public int getBeforeMonth(int startMonth){
        LocalDate local=LocalDate.now();
        int leapYear[]={31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};  //闰年
        int commonYear[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //平年
        int year=local.getYear();
        if(year%4==0&&year%100!=0||year%400==0){
            return leapYear[startMonth-1];
        }else
        return commonYear[startMonth-1];
    }

    //将时间转换为时间戳
    public long getDateTime(String date){
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