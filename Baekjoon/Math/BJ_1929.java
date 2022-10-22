package Math;

import java.util.Scanner;

public class BJ_1929 {
    // 백준 1929
    // 소수 구하기
    // 에라토스테네스의 체

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        boolean[] prime = new boolean[n + 1];

        prime[0] = prime[1] = true;

        // 소수 다 정의하고 시작
        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = m; i <= n; i++) {
            if (!prime[i]) {
                System.out.println(i);
            }
        }

    }
}
