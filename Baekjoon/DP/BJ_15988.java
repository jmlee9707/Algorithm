package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_15988 {
    /*
     * 백준 15988
     * 1,2,3 더하기 3
     */
    static int T, cnt;
    static int[] tcNums;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        tcNums = new int[T + 1];

        for (int i = 1; i <= T; i++) {
            // testcase
            tcNums[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 1000001; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
        }
        for (int i = 1; i <= T; i++) {
            System.out.println(dp[tcNums[i]]);
        }
    }

}
