package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1749 {
    /*
     * 백준 1749
     * 점수 따먹기
     */
    static int N, M;
    static int[][] map;
    static int[][] prefix;
    static long MAX = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        prefix = new int[N + 1][M + 1];

        // 시간 최대 200*200 => 40,000 시간 소요
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + map[i][j]; // 누적합 구하기
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {

                for (int r = 1; r <= i; r++) {
                    for (int c = 1; c <= j; c++) {
                        long res = prefix[i][j] - prefix[r - 1][j] - prefix[i][c - 1] + prefix[r - 1][c - 1];
                        MAX = Math.max(res, MAX);
                    }
                }
            }
        }

        System.out.println(MAX);

    }
}
