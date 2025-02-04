package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_12101 {
    /*
     * 백준 12101
     * 1,2,3 더하기 2
     */
    static int n, k, cnt;
    static String[] expression;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        expression = new String[k + 1];
        nums = new int[11];
        cnt = 0;

        plus(0, 0);

        System.out.println("-1");
    }

    public static void plus(int sum, int count) {

        if (sum == n) {
            cnt++;
            if (cnt == k) {
                String str = "";
                for (int i = 0; i < count - 1; i++) {
                    str += nums[i] + "+";
                }
                str += nums[count - 1];
                System.out.println(str);
                System.exit(0);
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (sum + i > n)
                continue;

            nums[count] = i;
            plus(sum + i, count + 1);
        }

    }
}
