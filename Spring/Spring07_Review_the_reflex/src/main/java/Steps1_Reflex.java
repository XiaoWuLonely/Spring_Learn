public class Steps1_Reflex {
    public void doSome(){
        System.out.println("doSome(Void)");
    }

    public String doSome(String s){
        System.out.println("doSome(String)");
        return s;
    }

    public String doSome(String s,int i){
        System.out.println("doSome(String,Int)");
        return s+i;
    }
}

