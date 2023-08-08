package Softeer;

import java.util.Scanner;

public class Virus {
    /*
     * 소프티어 바이러스
     * lv2
     * https://softeer.ai/practice/info.do?idx=1&eid=407
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long K = sc.nextLong();
        long P = sc.nextLong();
        long N = sc.nextLong();

        for (int i = 1; i <= N; i++) {
            K = K * P % 1000000007;
        }

        System.out.println(K);
    }
}
