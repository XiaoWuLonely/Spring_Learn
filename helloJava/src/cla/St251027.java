package cla;

public class St251027 {
    public static void main(String[] args) {
        St251027C student=new St251027C();
        student.name="zxk";
        student.age=10086;
        System.out.println("我叫"+student.name+",我"+student.age+"岁");
        student.eat();
        student.sleep();

        St251027B teacher=new St251027B();
        teacher.name="zxk";
        teacher.salary=50;
        System.out.println("我是"+teacher.name+",工资是"+teacher.salary+"元");
        teacher.work();

        St251027A stu=new St251027A();
        stu.name="zxk";
        stu.sno=123456;
        System.out.println("我是"+stu.name+",学号是"+stu.sno);
        stu.study();
    }
}
