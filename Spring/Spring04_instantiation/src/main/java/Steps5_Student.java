import java.util.Date;

public class Steps5_Student {
    private Date birth;

    // java.util.Date 在Spring当中被当做简单类型。但是简单类型的话,注入的日期字符串格式有要求。
// java.util.Date 在Spring当中也可以被当做非简单类型。
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Steps5_Student{" + "Birth=" + birth + '}';
    }


}
