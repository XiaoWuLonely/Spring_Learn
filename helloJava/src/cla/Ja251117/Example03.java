package cla.Ja251117;


class Animal {
    // 定义父类speak()方法
    public void speak() {
        System.out.println("动物发出叫声");
    }
}

class Cat extends Animal {
    // 重写父类speak()方法
    @Override
    public void speak() {
        System.out.println("小猫：喵喵。。。");
    }
}

class Dog extends Animal {
    // 重写父类speak()方法
    @Override
    public void speak() {
        System.out.println("小狗：汪汪。。。");
    }
    public void houseKeep(){//子类特有方法
        System.out.println("狗狗会看家");
    }
}

public class Example03 {
    public static void main(String[] args) {
        Animal animal1 = new Cat();
        Animal animal2 = new Dog();
        f(animal1);
        f(animal2);

        //判断是否为狗狗
        if(animal2 instanceof Dog){
            //向下转型
            Dog dog=(Dog) animal2;
            dog.houseKeep();
        }else{
            System.out.println("不是狗狗");
        }
    }

    public static void f(Animal animal) {
        animal.speak();
    }
}
