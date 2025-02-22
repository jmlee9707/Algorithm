package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1932 {
    /*
     * 백준 1932
     * 정수 삼각형
     */
    static int N;
    static int[][] num, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + num[i][j];
            }
        }

        System.out.println(dp[0][0]);
    }
}
