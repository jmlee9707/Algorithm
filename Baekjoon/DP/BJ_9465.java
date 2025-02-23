package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9465 {
    /*
     * 백준 9465
     * 스티커
     */
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] board = new int[N + 2][3];
            int[][] dp = new int[N + 2][3];

            for (int i = 1; i <= 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 2; j <= N + 1; j++) {
                    board[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 2; i <= N + 1; i++) {
                int pick1 = dp[i - 1][2] + board[i][1];
                int nonePick = Math.max(dp[i - 2][1], dp[i - 2][2]);
                dp[i][1] = Math.max(pick1, nonePick + +board[i][1]);

                int pick2 = dp[i - 1][1] + board[i][2];
                dp[i][2] = Math.max(pick2, nonePick + +board[i][2]);

            }

            int res = Math.max(dp[N + 1][1], dp[N + 1][2]);
            System.out.println(res);

        }
    }
}
