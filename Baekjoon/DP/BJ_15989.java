package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_15989 {
    /*
     * 백준 15989
     * 1,2,3 더하기 4
     */
    static int T;
    static int[][] dp = new int[10001][4];
    static int[] tc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        tc = new int[T + 1];

        for (int i = 1; i <= T; i++) {
            tc[i] = Integer.parseInt(br.readLine());
        }

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        /*
         * dp[num][1] = dp[num-1][1]
         * dp[num][2] = dp[num-2][2] + dp[num-2][1]
         * dp[num][3] = dp[num-3][1] + dp[num-3][2] + dp[num-3][3]
         */

        for (int i = 4; i < 10001; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }

        for (int i = 1; i <= T; i++) {
            int num = tc[i];
            System.out.println(dp[num][1] + dp[num][2] + dp[num][3]);
        }

    }
}
