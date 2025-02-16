package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2096 {
    /*
     * 백준 2096
     * 내려가기
     */
    static int[][] map, dpMax, dpMin;
    static int N;
    static int max, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[N][3];
        dpMax = new int[N][3];
        dpMin = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dpMax[0][0] = map[0][0];
        dpMax[0][1] = map[0][1];
        dpMax[0][2] = map[0][2];
        dpMin[0][0] = map[0][0];
        dpMin[0][1] = map[0][1];
        dpMin[0][2] = map[0][2];

        for (int i = 1; i < N; i++) {
            dpMax[i][0] = map[i][0] + Math.max(dpMax[i - 1][0], dpMax[i - 1][1]);
            dpMin[i][0] = map[i][0] + Math.min(dpMin[i - 1][0], dpMin[i - 1][1]);

            dpMax[i][2] = map[i][2] + Math.max(dpMax[i - 1][2], dpMax[i - 1][1]);
            dpMin[i][2] = map[i][2] + Math.min(dpMin[i - 1][2], dpMin[i - 1][1]);

            dpMax[i][1] = map[i][1] + Math.max(dpMax[i - 1][0], Math.max(dpMax[i - 1][2], dpMax[i - 1][1]));
            dpMin[i][1] = map[i][1] + Math.min(dpMin[i - 1][0], Math.min(dpMin[i - 1][2], dpMin[i - 1][1]));
        }

        min = Math.min(dpMin[N - 1][2], Math.min(dpMin[N - 1][0], dpMin[N - 1][1]));
        max = Math.max(dpMax[N - 1][2], Math.max(dpMax[N - 1][0], dpMax[N - 1][1]));

        System.out.println(max + " " + min);
    }
}
