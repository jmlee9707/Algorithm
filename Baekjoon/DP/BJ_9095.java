package DP;

import java.io.IOException;
import java.util.Scanner;

public class BJ_9095 {
    static public int T, N, res, count;
    static public int[] cnt = new int[11];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        T = sc.nextInt();

        cnt[1] = 1;
        for (int i = 1; i < 11; i++) {
            count = 0;

            combi(i, i);
        }

        for (int i = 0; i < T; i++) {
            N = sc.nextInt(); // n은 11보다 작다
            sb.append(cnt[N] + "\n");
        }
        System.out.println(sb);
    }

    public static void combi(int num, int temp) {

        if (temp == 0) {
            count++;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (temp - i < 0)
                continue;
            combi(num, temp - i);
        }

        cnt[num] = count;
    }
}
