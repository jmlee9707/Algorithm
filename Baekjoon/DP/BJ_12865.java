package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12865 {
    /*
     * 백준 12865
     * 평범한 배낭
     */
    public static class Things {
        int idx, weight, value;

        public Things(int idx, int weight, int value) {
            this.idx = idx;
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][K + 1];
        Things[] thing = new Things[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            thing[i] = new Things(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= N; i++) {
            Things t = thing[i];
            for (int j = 1; j <= K; j++) {
                if (t.weight <= j)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - t.weight] + t.value);
                else // t.weight>=j
                    dp[i][j] = dp[i - 1][j];
            }
        }

        System.out.println(dp[N][K]);
    }
}
