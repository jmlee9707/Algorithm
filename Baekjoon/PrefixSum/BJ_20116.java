package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20116 {
    /*
     * 백준 20116
     * 상자의 균형
     */

    static int N, L;
    static long total;
    static int[] weight;
    static boolean stable = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        weight = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
            total += weight[i];
        }

        for (int i = 1; i < N; i++) {
            double cnt = N - i;
            double temp = (double) (total - weight[i]) / cnt;
            total -= weight[i];

            if (weight[i] - L < temp && weight[i] + L > temp)
                continue;
            else {
                stable = false;
                break;
            }
        }

        System.out.println(stable ? "stable" : "unstable");
    }
}
