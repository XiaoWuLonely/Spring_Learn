package zy;

class Student1 {
    private int no;
    private String name;
    private String sex;
    private int age;
    private int JavaScore;


    public Student1(int no, String name, String sex, int age, int JavaScore) {
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.JavaScore = JavaScore;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getJavaScore() {
        return JavaScore;
    }

    public void setJavaScore(int javaScore) {
        JavaScore = javaScore;
    }

    public void TestStudent() {
        System.out.println("学号：" + no + "姓名：" + name + "性别：" + sex + "年龄：" + age + "Java成绩：" + JavaScore);
    }
}
public class Java20251103 {
    public static void main(String[] args) {
        Student1 stu1 = new Student1(1001, "大一", "男", 20, 10000);
        Student1 stu2 = new Student1(1002, "小二", "男", 21, 20000);
        Student1 stu3 = new Student1(1003, "张三", "男", 22, 30000);
        Student1 stu4 = new Student1(1004, "李四", "男", 23, 40000);
        Student1 stu5 = new Student1(1005, "王五", "男", 24, 50000);


        stu1.TestStudent();
        stu2.TestStudent();
        stu3.TestStudent();
        stu4.TestStudent();
        stu5.TestStudent();

        int score = 0;
        score += stu1.getJavaScore();
        score += stu2.getJavaScore();
        score += stu3.getJavaScore();
        score += stu4.getJavaScore();
        score += stu5.getJavaScore();
        System.out.println("Java总成绩：" + score);
        System.out.println("Java平均成绩：" + (score / 5));
    }
}
