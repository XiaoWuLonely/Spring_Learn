package cla.Ja251117;

public class Demo10 {
    private static void handleSelfMehod(Rubbish rubbish) {
        if (rubbish instanceof DryRubbish) {
            DryRubbish dryRubbish = (DryRubbish) rubbish;
            dryRubbish.showInfo();
        } else if (rubbish instanceof RecyclableRubbish) {
            RecyclableRubbish recyclableRubbish = (RecyclableRubbish) rubbish;
            recyclableRubbish.handle();
        } else if (rubbish instanceof HarmfulRubbish) {
            HarmfulRubbish harmfulRubbish = (HarmfulRubbish) rubbish;
            harmfulRubbish.handle();
        } else {
            System.out.println(rubbish.getClass().getName() + "没有独有方法");
        }
    }

    public static void main(String[] args) {
        Rubbish rubbish = new Rubbish();
        Rubbish dryRubbish = new DryRubbish();
        Rubbish wetRubbish = new WetRubbish();
        Rubbish recyclableRubbish = new RecyclableRubbish();
        Rubbish harmfulRubbish = new HarmfulRubbish();
        handleSelfMehod(rubbish);
        handleSelfMehod(dryRubbish);
        handleSelfMehod(wetRubbish);
        handleSelfMehod(recyclableRubbish);
        handleSelfMehod(harmfulRubbish);
    }
}
