package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1890 {

    /*
     * 백준 1890
     * 점프
     */
    static int N;
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new long[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int step = map[i][j];
                if (step == 0)
                    break;

                if (i + step < N) {
                    dp[i + step][j] += dp[i][j];
                }
                if (j + step < N) {
                    dp[i][step + j] += dp[i][j];
                }

            }
        }

        System.out.println(dp[N - 1][N - 1]); // 종착점

    }

}
