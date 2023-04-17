package Math;

import java.util.Scanner;

public class BJ_23971 {
    /*
     * 백준 23971
     * ZOAC 4
     */

    static public int H, W, N, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        N = sc.nextInt();
        M = sc.nextInt();

        int hc = 0, wc = 0;

        if (H % (1 + N) == 0) {
            hc = H / (1 + N);
        } else
            hc = H / (1 + N) + 1;

        if (W % (1 + M) == 0) {
            wc = W / (1 + M);
        } else {
            wc = W / (1 + M) + 1;
        }

        System.out.println(wc * hc);
    }
}
