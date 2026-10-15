package cs01;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class java009Date {
    public static void main(String[] args){
        //获取当前日期
        LocalDate theDate= LocalDate.now();
        System.out.println(theDate);

        //指定日期
        LocalDate nationalDay = LocalDate.of(2025,10,1);
        System.out.println("国庆,"+nationalDay);

        //日期运算
        LocalDate tomorrow = theDate.plusDays(1);
        LocalDate nextMonth = theDate.plusMonths(1);
        LocalDate nextYear= theDate.plusYears(1);
        System.out.println(tomorrow);
        System.out.println(nextMonth);
        System.out.println(nextYear);

        //获取具体+时间戳
        System.out.println(LocalTime.now());
        //获取更加具体的日期+时间戳
        System.out.println(LocalDateTime.now());
        //获取选定地区的时间戳
        System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Shanghai")));
        //获取当前时间戳
        System.out.println(Instant.now());


        //日期的比较
        //一般方法
        Date time1=new Date(125,8,22);
        Date time2=new Date(124,7,21);
        System.out.println("time1"+time1);
        System.out.println("time2"+time2);
        System.out.println("compare："+(time1.getTime()>time2.getTime()));
        //使用 before(), after() 和 equals() 方法
        System.out.println("Before"+(time1.before(time2)));
        System.out.println("after"+(time1.after(time2)));
        System.out.println("Before"+(time1.equals(time2)));


        //格式化日期
        Date nowDate=new Date();
        SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(ft.format(nowDate));
    }
}
