package PrefixSum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_21318 {
    /*
     * 백준 21318
     * 피아노 체조
     */
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] paper = new int[N + 2];
        int[] mistake = new int[N + 2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            paper[i] = Integer.parseInt(st.nextToken());
        }

        mistake[0] = 0;
        paper[N + 1] = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            if (paper[i] > paper[i + 1]) {
                mistake[i] = mistake[i - 1] + 1;
            } else {
                mistake[i] = mistake[i - 1];
            }
        }
        mistake[N] = mistake[N - 1];
        int Q = Integer.parseInt(br.readLine());

        for (int t = 1; t <= Q; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int cnt = paper[y] > paper[y + 1] ? mistake[y] - mistake[x - 1] - 1 : mistake[y] - mistake[x - 1];

            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();

    }
}
