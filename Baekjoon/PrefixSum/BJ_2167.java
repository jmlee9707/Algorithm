package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2167 {
    /*
     * 백준 2167
     * 2차원 배열의 합
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int map[][] = new int[N + 1][M + 1];
        int prefix[][] = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                prefix[i][j] = map[i][j] + prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1];
            }
        }

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int temp = prefix[x][y] - prefix[i - 1][y] - prefix[x][j - 1] + prefix[i - 1][j - 1];

            System.out.println(temp);
        }

    }
}
