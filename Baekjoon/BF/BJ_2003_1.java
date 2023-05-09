package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2003_1 {
    /*
     * 백준 2003
     * 수들의 합2
     * 다시 푸는 문제
     */

    static int N, M, res;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        res = 0;

        // 투포인터 문제였다
        // for 문으로 완.탐 시에 시간복잡도 O(N^2)
        // 투포인터로 풀면 O(N)

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // bruteforce(); // 일반 완전탐색 풀이 -> 시간초과
        twoPointer();

        System.out.println(res);

    }

    public static void twoPointer() {
        int start = 0, end = 0, sum = 0;

        while (true) {
            if (sum >= M) {
                sum -= numbers[start];
                start++;
            } else if (end == N) {
                break;
            } else {
                sum += numbers[end];
                end++;
            }

            if (sum == M)
                res++;

        }

    }

    public static void bruteforce() {
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                checkSum(i, j);
            }
        }
    }

    public static void checkSum(int num1, int num2) {
        int sum = 0;
        for (int i = num1; i <= num2; i++) {
            sum += numbers[i];
        }
        if (sum == M)
            res++;
    }
}
