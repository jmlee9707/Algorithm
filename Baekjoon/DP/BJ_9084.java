package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9084 {
    /*
     * 백준 9084
     * 동전
     */
    static int T, N, targetMoney;
    static int[] types;
    static int[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            types = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                types[i] = Integer.parseInt(st.nextToken());
            }

            targetMoney = Integer.parseInt(br.readLine());
            dp = new int[N + 1][targetMoney + 1];
            calcMoney();
            System.out.println(dp[N][targetMoney]);

        }
    }

    public static void calcMoney() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= targetMoney; j++) {
                int coin = types[i]; // 1
                if (j - coin == 0) {
                    dp[i][j] = dp[i - 1][j] + 1;
                } else {
                    dp[i][j] = j - coin >= 0 ? dp[i - 1][j] + dp[i][j - coin] : dp[i - 1][j];
                }

            }
        }
    }
}
