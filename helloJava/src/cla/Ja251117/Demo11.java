package cla.Ja251117;

class Parent {
    public String name;

    public void eat() {
        System.out.println("父类：吃");
    }

    public static void sleep() {
        System.out.println("父类：睡");
    }
}

class Child extends Parent {
    public String name;
    public int age;


    public void eat() {
        System.out.println("子类：吃");
    }

    public static void sleep() {
        System.out.println("子类：睡");
    }

    public void cry() {
        System.out.println("子类：哭");
    }
}

public class Demo11 {
    public static void main(String[] args) {
        Child child = new Child();
        child.name = "张三";

        Parent parent = child;
        parent.name = "李四";
        System.out.println(parent.name);
        System.out.println(child.name);
        parent.eat();
        parent.sleep();
        child.eat();
        child.sleep();
        //parent.cry();
    }
}
