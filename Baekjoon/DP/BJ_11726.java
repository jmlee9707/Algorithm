package DP;

import java.util.Scanner;

public class BJ_11726 {
    // 2xn 타일링
    // 백준 11726
    // dp

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 1*2, 2*1 타일로 채우는 방법의 수
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            // 나누기 연산을 한 결과값을 출력해야 할 때에는 반드시 연산 할때마다 나누기 연산을 해주어야 한다
            // 계속 숫자를 더하고 마지막 출력시에만 나누기 연산을 할경우
            // overflow 가 발생하기 때문에 잘못된 값이 출력될 수 있다.
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[n] % 10007);

    }
}
