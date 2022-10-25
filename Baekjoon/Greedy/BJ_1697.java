package Greedy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * BJ_1697
 * 숨바꼭질
 */

public class BJ_1697 {
    static int N, K, res;
    static int[] check = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        res = 0;

        if (N == K) {
            System.out.println(0);

        } else {
            res = bfs();
            System.out.println(res);
        }

    }

    static public int bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(N); // 처음 시작점
        check[N] = 0;

        while (!que.isEmpty()) {
            int temp = que.poll();

            if (temp == K) // 수빈이가 동생을 찾으면 종료
                return (check[temp]);

            for (int i = 0; i < 3; i++) {
                int num = 0; // 새로운 수
                if (i == 0)
                    num = temp - 1;
                else if (i == 1)
                    num = temp + 1;
                else if (i == 2)
                    num = temp * 2;

                if (num >= 0 & num <= 100000 && check[num] == 0) {
                    que.add(num);
                    check[num] = check[temp] + 1;
                }
            }
        }

        return -1;

    }
}
