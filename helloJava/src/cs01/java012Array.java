package cs01;

import java.util.Arrays;

public class java012Array {
    public static void main(String[] args) {
        int[] score=new int[2];
        score[0]=100;
        score[1]=200;
        System.out.println(Arrays.toString(score));

        int[] arr=new int[]{3,2,1};
        System.out.println(Arrays.toString(arr));

        int[] key={5,4,3,2,1};
        System.out.println(Arrays.toString(key));

        String[] db={"name","age","gender"};
        System.out.println(Arrays.toString(db));

        //便利数组
        for(String item:db){
            System.out.println(item);
        }
    //多维数组
        //[行][列]
        String[][] str = new String[3][4];
        str[1][0]="name";
        str[1][1]="age";
        System.out.println(Arrays.toString(str[1]));

        int[][] kkk={{1,2,3,4},{3,4,5,6},{6,7,8,9}};
        System.out.println(Arrays.toString(kkk[1]));
        System.out.println(kkk.length);

        System.out.println("");
        // 便利二维数组
        for(int i=0;i<kkk.length;i++){
            for(int k=0;k<kkk[i].length;k++){
                System.out.println(kkk[i][k]);
            }
        }

        System.out.println("");

        for(int item:kkk[0]){
            System.out.println(item);
        }
    }
}
