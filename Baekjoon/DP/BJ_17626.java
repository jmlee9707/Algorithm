package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_17626 {
    /*
     * 백준 17626
     * Four Squares
     */
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = N;
        int res = 0;

        int dp[] = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;

        System.out.println(res);

    }

    public static int dp(int n) {
        return (int) Math.sqrt(n);
    }

}
