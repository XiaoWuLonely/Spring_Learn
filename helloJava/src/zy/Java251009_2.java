package zy;

import java.util.Scanner;

public class Java251009_2 {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println("请输入里程，（整数）");
            Scanner Any = new Scanner(System.in);
            System.out.println("是否高峰时段，（true/false）");
            Scanner Bl = new Scanner(System.in);

            int sum = Any.nextInt();
            Boolean height = Bl.nextBoolean();
            double dd;

            if (height) {
                dd = 1.2;
            } else {
                dd = 1.0;
            }
            if (sum <= 3) {
                System.out.println(3 * dd);
            } else if (sum > 3 && sum <= 10) {
                System.out.println((3 + (sum - 3) * 0.5) * dd);
            } else {
                System.out.println((3 + (sum - 3) * 0.3) * dd);
            }
        }

    }
}
