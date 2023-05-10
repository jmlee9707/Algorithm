package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2961_1 {
    /*
     * 백준 2961
     * 도영이가 만든 맛있는 음식
     */
    static int N, min; //
    static int[][] food;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        food = new int[N][2]; // 0: sour, 1 : bitter
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            food[i][0] = Integer.parseInt(st.nextToken());
            food[i][1] = Integer.parseInt(st.nextToken());
        }
        // 신맛 : 사용한 재료의 곱
        // 쓴맛 : 사용한 재료의 합
        min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            // i : 사용하는 재료
            // nCi
            combi(0, i, 0, 1, 0);
        }
        System.out.println(min);

    }

    public static void combi(int cnt, int i, int start, int sourSum, int bitSum) {
        if (cnt == i) {
            // 다 뽑으면
            int dist = Math.abs(sourSum - bitSum);
            min = Math.min(dist, min);
            return;
        }

        for (int j = start; j < N; j++) {
            combi(cnt + 1, i, j + 1, food[j][0] * sourSum, food[j][1] + bitSum);
        }
    }

}
