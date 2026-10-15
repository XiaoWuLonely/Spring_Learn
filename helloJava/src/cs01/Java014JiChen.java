package cs01;

class Person1 {
    public void run() {
        System.out.println("Person1.run");
    }
}
 // 子类继承了父，但同时自己也有相同的功能函数。
class Student1 extends Person1 {
    // 覆写（Override）：子类可以重新定义父类的方法，实现自己的功能
    @Override
    public void run() {
        System.out.println("Student1.run");
    }
}
public class Java014JiChen {
    public static void main(String[] args) {
        Student1 stu1 = new Student1();
        // 这里调用的就是子类的方法。会覆盖父类的方法。
        stu1.run();

        Person1 p1 = new Student1();
        p1.run();
    }

}