package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11053 {
    /*
     * 백준 11053
     * 가장 긴 증가하는 부분 수열
     */
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int[] nums = new int[N + 1];

        dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 단순 증가가 아님

        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }

}
