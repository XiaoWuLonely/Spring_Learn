package cs02.异常.chapt13;

import java.util.Calendar;

public class Demo1Calendar {
    public static void main(String[] args) throws Exception {
        // 获取表示当前时间的calendar对象
        Calendar calendar = Calendar.getInstance();
        // 获取date
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int date = calendar.get(Calendar.DATE);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        System.out.println("当前时间：" + year + "年" + month + "月" + date +
                "日" + hour + "时" + second + "分" + second + "秒");
    }
}
