package 정민.백준;

import java.util.Scanner;

/**
 * BJ_2023
 */
public class BJ_2023 {

    // 신기한 소수
    // 백준 2023

    static public int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        // 한자리수 소수 => 1, 2, 3, 5, 7 로 중복 순열?
        // 에라토스테네스의 체 - n보다 작거나 같은 모든 소수를 찾는 알고리즘

        int[] num = { 2, 3, 5, 7 };

        // 첫자리는 1 불가, 2,3,5,7 중 하나
        for (int i = 0; i < 4; i++) {
            check(1, num[i]);
        }
    }

    public static void check(int cnt, int num) {
        if (cnt == n) {
            if (isPrime(num))
                System.out.println(num);
            return;
        }
        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0)
                continue;
            if (isPrime(num * 10 + i))
                check(cnt + 1, num * 10 + i);
        }
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0)
                return false; // 소수가 아님
        }
        return true;
    }
}