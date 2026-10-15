package cla;

class  animal{
    void show(){
        System.out.println("I am animal");
    }
}

class dog extends  animal{
    public void shout(){
        System.out.println("worf");
    }
}

public class St251027D {
    public static void main(String[] args) {
        dog dog =new dog();
        dog.show();
        dog.shout();
    }
}
