package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1003 {
    // 피보나치 수 구하기
    // 피보나치에서 0과 1이 호출되는 횟수를 구하기
    // 이미 한번 호출된 수라면 배열에 담기
    static int N, T;
    static int[] zero, one, order;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        // count = new count[40][2];
        zero = new int[41];
        one = new int[41];
        order = new int[T];
        zero[0] = 1;
        zero[1] = 0;
        one[0] = 0;
        one[1] = 1;

        for (int t = 0; t < T; t++) {
            // N은 40보다 작거나 같은 자연수 또는 0
            N = Integer.parseInt(br.readLine());
            order[t] = N;
        }

        // dp 배열을 만들어 i를 증가시키면서 40까지 값을 구해놓은 뒤 정답을 출력
        for (int i = 2; i < 41; i++) {
            zero[i] = zero[i - 1] + zero[i - 2];
            one[i] = one[i - 1] + one[i - 2];
        }

        // ============ 출력 ============
        for (int t = 0; t < T; t++) {
            System.out.println(zero[order[t]] + " " + one[order[t]]);
        }

    }

    // public static int fibo(int n) {
    // if (n == 0) {
    // zero++;
    // return 0;
    // } else if (n == 1) {
    // one++;
    // return 1;
    // } else {
    // return fibo(n - 1) + fibo(n - 2);

    // }
    // }
}
