package Math;

import java.util.Scanner;

public class BJ_5543 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ba = sc.nextInt();
        int bb = sc.nextInt();
        int bc = sc.nextInt();
        int da = sc.nextInt();
        int db = sc.nextInt();

        int minB = Math.min(ba, bb);
        minB = Math.min(minB, bc);

        int minD = Math.min(da, db);

        System.out.println(minB+minD-50);

    }
}
