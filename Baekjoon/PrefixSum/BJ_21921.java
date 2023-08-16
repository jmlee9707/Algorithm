package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_21921 {
    /*
     * 백준 21921
     * 블로그
     * 투포인터, 누적합
     */

    static int X, N, max, cnt;
    static int[] today;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        today = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            today[i] = Integer.parseInt(st.nextToken());
        }
        max = 0;

        twoPointer(X);

        if (max == 0)
            System.out.println("SAD");
        else
            System.out.println(max + "\n" + cnt);
    }

    public static void twoPointer(int dur) {
        int start = 1, end = 1;

        for (int i = 1; i <= dur; i++) {
            max += today[i];
        }
        cnt = 1;
        end = dur;
        int sum = max;

        while (end < N) {
            sum = sum + today[end + 1] - today[start];
            start++;
            end++;
            if (sum == max) {
                cnt++;
            }
            if (sum > max) {
                cnt = 1;
                max = sum;
            }
        }

    }

}
