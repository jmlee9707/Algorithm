package DP;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_14916 {
    /*
     * 백준 14916
     * 거스름돈
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[Math.max(N + 1, 6)];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = -1;
        dp[2] = 1;
        dp[3] = -1;
        dp[4] = 2;
        dp[5] = 1;

        for (int i = 6; i <= N; i++) {
            if (dp[i - 2] == -1 && dp[i - 5] == -1)
                dp[i] = -1;
            else if (dp[i - 2] == -1)
                dp[i] = dp[i - 5] + 1;
            else if (dp[i - 5] == -1)
                dp[i] = dp[i - 2] + 1;
            else
                dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
        }
        System.out.println(dp[N]);
    }
}
