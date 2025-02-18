package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15650 {
    /*
     * 백준 15650
     * N과 M (2)
     */
    static int N, M;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = new int[M];

        permutation(0, 1);
    }

    public static void permutation(int cnt, int start) {
        if (cnt == M) {
            String str = "";
            for (int i = 0; i < M; i++) {
                if (i == M - 1)
                    str += num[i];
                else
                    str += num[i] + " ";
            }
            System.out.println(str);
            return;
        }

        for (int n = start; n <= N; n++) {
            num[cnt] = n;
            permutation(cnt + 1, n + 1);
        }
    }
}
