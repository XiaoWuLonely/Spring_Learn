package edu.baiyun.chapt13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo2SimpleDateFormat {
    public static void main(String[] args) throws ParseException {
        // 定义日期时间的字符串
        String time = "2021-03-02 17:26:11.234";
        // 定义日期时间的模板
        String patten = "yyyy-mm-dd HH:mm:ss.SSS";
        // 创建SimpleDateFormat对象
        SimpleDateFormat format = new SimpleDateFormat(patten);
        // 按SimpleDateFormat对象的日期模板将字符串格式化为Date对象
        Date date = format.parse(time);
        System.out.println(date);
    }
}
