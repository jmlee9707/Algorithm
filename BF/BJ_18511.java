package BF;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * BJ_18511
 * 큰 수 구성하기
 */
public class BJ_18511 {

    static int N, K, ans;
    static Integer[] arr;// int에서는 내림차순 정렬 사용 불가

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // N = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

        arr = new Integer[K];
        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
        }

        // ===== 입출력 끝 ========

        // int에서는 사용 불가
        Arrays.sort(arr, Comparator.reverseOrder()); // 정렬
        ans = 0;
        findMax(0);
        System.out.println(ans);
    }

    static public void findMax(int now) {
        System.out.println(now);
        if (now > N)
            return;

        if (ans < now)
            ans = now;

        for (int i = 0; i < K; i++) {
            findMax(now * 10 + arr[i]);
        }

    }
}