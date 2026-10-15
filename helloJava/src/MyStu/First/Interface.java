package MyStu.First;

interface InteFace{
    void speak();
}

class dogInte implements InteFace {
    @Override
    public void speak() {
        System.out.println("Dog is Barks");
    }
}

public class Interface {
    public static void main(String[] args) {
        dogInte d = new dogInte();
        d.speak();
    }
}
