package edu.baiyun.chapt13;

import java.util.Date;

public class DemoDate {
    public static void main(String[] args) {
        Date date1 = new Date();
        Date date2 = new Date(867686400000L);
        System.out.println("date1：" + date1);
        System.out.println("date2：" + date2);
        System.out.println("date1 before date2：" + date1.before(date2));
        System.out.println("date1 after date2：" + date1.after(date2));
        System.out.println("date1 equals date2：" + date1.equals(date2));
        System.out.println("date1 getTime：" + date1.getTime());
        // 计算两个日期相差天数
        long time1 = date1.getTime();
        long time2 = date2.getTime();
        long day = (time1 - time2) / 1000 / 60 / 60 / 24;
        System.out.println("date1 - date2 = " + day + " day");
        date2.setTime(System.currentTimeMillis());
        System.out.println("date2 setTime：" + date2);
    }
}
