package edu.baiyun.chapt13;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo1SimpleDateFormat {
    public static void main(String[] args) throws Exception {
        // 创建代表当前时间的Date对象
        Date date = new Date();
        // 创建SimpleDateFormat对象，指定想要的格式：yyyy年MM月dd日
        SimpleDateFormat f = new SimpleDateFormat("yyyy年MM月dd日");
        // 按SimpleDateFormat对象的日期模板格式化Date对象
        String s = f.format(date);
        System.out.println("date格式化后：" + s);
    }
}
