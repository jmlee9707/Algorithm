package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1010 {
    /*
     * 백준 1010
     * 다리 놓기
     * dp
     */
    static int T, N, M, res;
    static int[] selected;
    static int [][] dp

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        dp = new int[30][30]; // 
        initDp();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // sb.append(makeCombi(N, M) + "\n"); => 시간초과
            sb.append(dp[N][M] + "\n");
        }

        System.out.println(sb);
    }                  

    public static void initDp() {

    }

    public static int makeBridge(int left, int right) { // dp 풀이
        res = 0;

        return res;
    }

    public static int makeCombi(int n, int m) { // 조합론 풀이 -> 시간초과~~~
        // m개 중에 n개 선택
        res = 0;
        selected = new int[n];
        combination(0, 0);
        return res;
    }

    public static void combination(int start, int cnt) {
        if (cnt == N) {
            res++;
            return;
        }

        for (int i = start; i < M; i++) {
            selected[cnt] = i;
            combination(i + 1, cnt + 1);
        }
    }

}
