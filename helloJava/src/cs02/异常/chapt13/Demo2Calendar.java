package edu.baiyun.chapt13;

import java.util.Calendar;

public class Demo2Calendar {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();  // 获取表示当前时间的calendar实例
        calendar.set(2025,1,1);  // 设置指定日期
        calendar.add(Calendar.DATE,100);   // 增加100天
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int date = calendar.get(Calendar.DATE);
        System.out.println("计划竣工日期：" + year + "年" + month + "月" +
                date + "日");

    }
}
