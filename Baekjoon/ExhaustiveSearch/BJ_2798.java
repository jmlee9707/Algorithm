package ExhaustiveSearch;

import java.util.Scanner;

// 브루트포스 - 완전탐색 
public class BJ_2798 {
    // 블랙잭
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] card = new int[N];
        for (int i = 0; i < N; i++) {
            card[i] = sc.nextInt();
        }
        // 순열 조합 사용
        // nC3 -> m과 가장 가까운 수
        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int sum = card[i] + card[j] + card[k];
                    if (sum <= M && sum > max) {
                        max = sum;
                    }
                }
            }
        }

        System.out.println(max);
    }
}
