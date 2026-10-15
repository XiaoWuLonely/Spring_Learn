package cla;

public class St251103T {
    public static void main(String[] args) {
        St251103 s1 = new St251103();
        s1.name = "zxk";
        s1.age = 23;
        s1.eat();
        System.out.println(s1);
        System.out.println(s1.toString());

        St251103 ss = new St251103();
        ss.name = "zxk";
        ss.age = 23;
        System.out.println(s1.equals(ss));
        System.out.println(s1.hashCode());


        St251103 s2 = new St251103();
        s2.name = "哈吉米";
        s2.age = 10086;
        s2.eat();
        System.out.println(s2.toString());
        System.out.println(s2.hashCode());
    }
}