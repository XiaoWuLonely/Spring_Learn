package cla;

public class St250922 {
    public static void main(String[] args){
        int num=0;
        while(true){
            num++;
            if(num%2==1){
                continue;
            }
            if(num%3==2&&num%5==3&&num%7==4){
                System.out.println("要"+num);
                break;
            }
        }

        int count =0;
        int numcount=2;
        while(true){
            boolean flag=true;
            for(int i =2;i<numcount;i++){
                if(numcount%i==0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                System.out.println("素数："+numcount+"\t");
                numcount++;
                if(numcount%5==0){
                    System.out.println();
                }
                if(numcount==20){
                    break;
                }
            }
            numcount++;
        }
    }
}
