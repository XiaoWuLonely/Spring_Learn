package MyStu.First;

import java.util.Arrays;

public class Array {
    public static void main(String[] args){
        int[] a ={1,2,3,4,5};
        int[] b =new int[5];
        int[][] c = new int[5][5];

        for(int i=0;i<5;i++)  b[i]=i*i;
        Arrays.sort(b);
        for(int i:b){
            System.out.println(i);
        }

    }
}
