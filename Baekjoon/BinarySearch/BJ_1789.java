package BinarySearch;

import java.util.Scanner;

public class BJ_1789 {
    /*
     * 백준 1789
     * 수들의 합
     * silver 5
     */
    static long S, res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.nextLong();
        // 서로 다른 N개의 자연수의 합 S
        // N의 최댓값은?

        // 왜 이진탐색 문제인가?
        // S의 최댓값이 40억
        // 탐색범위가 넓으므로 당연히 이진탐색

        long start = 1;
        long end = S;
        long middle = 0, sum = 0;

        while (true) {
            if (start > end)
                break;

            middle = (end + start) / 2;
            sum = calc(middle);

            if (sum > S) {
                end = middle - 1;
            } else if (sum < S) {
                res = Math.max(middle, res);
                start = middle + 1;
            } else {
                res = middle;
                break;
            }
        }

        System.out.println(res);
    }

    public static long calc(long n) {
        long temp = 0;

        temp = (n + 1) * (n / 2);
        if (n % 2 == 1)
            temp += (n + 1) / 2;
        return temp;
    }
}
