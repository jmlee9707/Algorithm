package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10422 {
    /*
     * 백준 10422
     * 괄호
     */
    static int T, L;
    static long[] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        dp = new long[5001];

        dp[0] = 1; // init
        dp[2] = 1;

        for (int i = 2; i <= 2500; i++) {
            for (int j = 0; j < i; j++) {
                dp[i * 2] += dp[j * 2] * dp[(i - j - 1) * 2];
                dp[i * 2] %= 1000000007L;
            }
        }

        for (int tc = 1; tc <= T; tc++) {
            L = Integer.parseInt(br.readLine());
            System.out.println(dp[L]);
        }

    }
}
