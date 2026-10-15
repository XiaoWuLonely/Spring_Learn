package cla;

class ElectAPP {
    String type;
     double num;
    public ElectAPP() {
        System.out.println("I am ElectAPP1");
    }

    public ElectAPP(String type) {
        this.type = type;
        System.out.println("I am ElectAPP2 " + type);
    }

    public void turnON() {
        System.out.println("I am ElectAPP ON");
    }
}

class TV extends ElectAPP {
    String type;
    String brand;

    public TV(String type,String tvType, String brand) {
        super(type);
        this.type = tvType;
        this.brand = brand;
        System.out.print("I am TV3" + type + " " + brand);
    }

    @Override
    public void turnON() {
        System.out.println("I am TV4" + type + " ON");
    }

    public void turn() {
        System.out.println("电视机类型5" + super.type);
        System.out.println("电视机类型6" + type);
        super.turnON();
        turnON();
    }
}

public class St251031 {
    public static void main(String[] args) {
        TV TV=new TV("LED","liquid LED","Hair");
        TV.turn();
        System.out.println("电视机品牌"+TV.type+TV.brand);
    }

}
