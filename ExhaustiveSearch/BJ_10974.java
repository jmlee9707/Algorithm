package ExhaustiveSearch;

import java.util.Scanner;

public class BJ_10974 {
    // 모든 순열
    static int n;
    static int[] numbers;
    static boolean[] check; // 중복 확인 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        numbers = new int[n];
        check = new boolean[n + 1];

        perm(0);

    }

    public static void perm(int cnt) {

        if (cnt == n) {
            // 사전순 출력!
            for (int i = 0; i < n - 1; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println(numbers[n - 1]);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (check[i])
                continue;

            numbers[cnt] = i;
            check[i] = true;
            perm(cnt + 1);
            check[i] = false;
        }

    }
}
