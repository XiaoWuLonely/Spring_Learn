package zy;

class Rubbish{
    public void classify(){
        System.out.println("这是垃圾、要分类");
    }
    public void showInfo(){}
    public void handle(){}
}
class DryRubbish extends Rubbish{
    @Override
    public void classify(){
        System.out.println("这是干垃圾、要分类");
    }
    public void showInfo(){
        System.out.println("分类后直接扔了");
    }
}
class wetRubbish extends  Rubbish{
    @Override
    public void classify(){
        System.out.println("这是湿垃圾、要分类");
    }
}
class RecyclableRubbish extends Rubbish{
    @Override
    public void classify(){
        System.out.println("这是可回收垃圾");
    }
    public void handle(){
        System.out.println("分类后回收了");
    }
}
class HarmfulRubbish extends Rubbish{
    @Override
    public void classify(){
        System.out.println("这是有害垃圾、要分类");
    }
    public void handle(){
        System.out.println("必须处理好");
    }
}
public class Category_OF_Rubbish {
    public static void main(String[] args) {
        Rubbish rubbish=new Rubbish();
        Rubbish dryRubbish=new DryRubbish();
        Rubbish wetRubbish=new wetRubbish();
        Rubbish recyclableRubbish=new RecyclableRubbish();
        Rubbish harmfulRubbish=new HarmfulRubbish();
        rubbish.classify();
        dryRubbish.classify();
        wetRubbish.classify();
        recyclableRubbish.classify();
        harmfulRubbish.classify();
        dryRubbish.showInfo();
        recyclableRubbish.handle();
        harmfulRubbish.handle();
    }
}
