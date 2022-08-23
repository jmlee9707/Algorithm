package ExhaustiveSearch;

import java.util.Scanner;

public class BJ_2003 {
    static int n, m, res;
    static int[] input;

    public static void main(String[] args) {
        // 수들의 합2
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        input = new int[n + 1];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt(); // 입력 받기
        }

        res = 0; // 경우의 수

        // 투포인터로 접근하기!!!!!, 둘 다 첫번째 원소에서 시작
        int start = 0;
        int end = 0;
        int sum = 0;

        while (end <= n) {
            if (sum >= m) {
                // sum이 m이랑 같거나 크면 start++
                sum -= input[start++];
            } else {
                // sum이 m보다 작으면 end++;
                sum += input[end++];
            }

            if (sum == m)
                res++;
        }

        System.out.println(res);

    }
}
