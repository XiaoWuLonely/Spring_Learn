package cla.Ja251117;

class Rubbish {
    public void classify() {
        System.out.println("垃圾分类");
    }
}

class DryRubbish extends Rubbish {
    @Override
    public void classify() {
        System.out.println("干垃圾");
    }

    // 干垃圾独有的方法
    public void showInfo() {
        System.out.println("干垃圾分类完可以直接扔");
    }
}

class HarmfulRubbish extends Rubbish {
    @Override
    public void classify() {
        System.out.println("有害垃圾");
    }

    public void handle() {
        System.out.println("有害垃圾必须要经过处理");
    }
}

class RecyclableRubbish extends Rubbish {
    @Override
    public void classify() {
        System.out.println("可回收垃圾");
    }

    public void handle() {
        System.out.println("可回收垃圾可以变废为宝");
    }
}

class WetRubbish extends Rubbish {
    @Override
    public void classify() {
        System.out.println("湿垃圾");
    }
}

public class Demo8Rubbish {
    public static void main(String[] args) {
        Rubbish rubbish = new Rubbish();
        Rubbish dryRubbish = new DryRubbish();
        Rubbish wetRubbish = new WetRubbish();
        Rubbish recyclableRubbish = new RecyclableRubbish();
        Rubbish harmfulRubbish = new HarmfulRubbish();
        rubbish.classify();
        dryRubbish.classify();
        wetRubbish.classify();
        recyclableRubbish.classify();
        harmfulRubbish.classify();
    }
}
