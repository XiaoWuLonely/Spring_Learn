package cla.Ja251117;


public class Demo9 {
    private static void handleClassify(Rubbish rubbish){
        rubbish.classify();
    }
    public static void main(String[] args) {
        Rubbish rubbish = new Rubbish();
        Rubbish dryRubbish = new DryRubbish();
        Rubbish wetRubbish = new WetRubbish();
        Rubbish recyclableRubbish = new RecyclableRubbish();
        Rubbish harmfulRubbish = new HarmfulRubbish();
        handleClassify(rubbish);
        handleClassify(dryRubbish);
        handleClassify(wetRubbish);
        handleClassify(recyclableRubbish);
        handleClassify(harmfulRubbish);
    }
}
