package Baekjoon.BF;

import java.util.Scanner;

public class BJ_1065 {
    /*
     * 백준 1065
     * 한수
     */
    static int N, res;
    static boolean[] han;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        han = new boolean[N + 1];
        res = 0;
        for (int i = 1; i <= N; i++) {
            if (han[i])
                continue;
            checkisHan(i);
        }
        for (int i = 1; i <= N; i++) {
            if (han[i])
                res++;
        }
        System.out.println(res);
    }

    public static void checkisHan(int n) {
        if (n < 100 && n >= 1)
            han[n] = true;
        else {
            // 3자리 수 이상일 경우
            String num = n + "";
            int dis = (num.charAt(1) - '0') - (num.charAt(0) - '0');
            boolean isHan = true;

            for (int i = 2; i < num.length(); i++) {
                int temp = (num.charAt(i) - '0') - (num.charAt(i - 1) - '0');
                if (temp != dis)
                    isHan = false;
            }
            if (isHan)
                han[n] = true;

        }

    }
}
