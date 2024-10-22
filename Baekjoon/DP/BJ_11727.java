package DP;

import java.util.Scanner;

public class BJ_11727 {
    /*
     * 백준 11727
     * 2*n 타일링 2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int dp[] = new int[Math.max(N + 1, 3)];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= N; i++) {
            dp[i] = ((dp[i - 2] * 2) + dp[i - 1]) % 10007;
        }

        System.out.println(dp[N]);

    }
}
