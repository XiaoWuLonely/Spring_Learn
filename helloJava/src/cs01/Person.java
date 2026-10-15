package cs01;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println(this.name);
        System.out.println(this.age);
    }
    public static void main(String[] args) {
        Person p = new Person("Alice", 25);
    }
}