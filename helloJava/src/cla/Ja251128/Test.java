package cla.Ja251128;

class Animal {
    void sound() {
    }
}

class Dog extends Animal {
    @Override
    void sound() {
    }
}

public class Test {
    public static void main(String[] args) {
        Animal Dog = new Animal() {
            @Override
            void sound() {
                System.out.println("大狗大狗叫叫叫");
            }
        };
        Dog.sound();
    }
}
