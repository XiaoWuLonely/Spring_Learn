package zy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Java251013 {
    public static void main(String[] args) {
        int[] arr1={1,2,3,4,5,6};
        int sum=0;
        for(int item:arr1){
            sum+=item;
        }
        System.out.println("数组和值:"+sum);
        System.out.println("数组平均值:"+sum/arr1.length);
/// /////////////////////////////////////////////////////////////
        int[][] m1={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] m2=new int[m1[0].length][m1.length];
        for (int i=0;i<m1.length;i++){
            for(int j=0;j<m1[i].length;j++){
                m2[j][i]=m1[i][j];
            }
        }
        System.out.print(Arrays.toString(m2[0]));
        System.out.print(Arrays.toString(m2[1]));
        System.out.print(Arrays.toString(m2[2]));
/// /////////////////////////////////////////////////////////////
        Scanner PhoneNumber = new Scanner(System.in);
        System.out.println("\n"+"请输入11手机号");
        if(PhoneNumber.hasNext()){
            String str = PhoneNumber.next();
            if(str.length()==11){
                StringBuffer newStr=new StringBuffer(str);
                newStr=newStr.replace(3,7,"****");
                System.out.println(newStr);
            }else {
                System.out.println("\n"+"请输入11位");
            }
        }
/// /////////////////////////////////////////////////////////////
        String BtS="helLo jaVa worLd";
        String[] BtSArr=BtS.split(" ");
        System.out.println(Arrays.toString(BtSArr));
        String BtSArr1="";
        for (int i=0;i<BtSArr.length;i++){
            BtSArr1=BtSArr1.concat(BtSArr[i].toLowerCase()+" ");
        }
        System.out.println(BtSArr1);
/// /////////////////////////////////////////////////////////////
        String[] frust={"apple", "banana", "orange"};
        StringBuilder newFrust=new StringBuilder();
        for (int i=0;i<frust.length;i++){
            newFrust.append(frust[i]+",");
        }
        System.out.println(newFrust);
    }
}
