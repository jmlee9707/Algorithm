
package BF;

import java.util.Scanner;

/**
 * BJ_2422
 */
public class BJ_2422 {

    // 백준 2422
    // 한윤정이 이탈리아에 가서 아이스크림을 사먹는데
    static boolean[][] imposs;
    static int[] selected; // 조합 방문 체크
    static boolean[] visited;
    static int N, M, res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 아이스크림 종류의 수
        M = sc.nextInt(); // 섞어먹으면 안되는 조합의 개수
        res = 0;

        imposs = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        selected = new int[3];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            imposs[a][b] = true;
            imposs[b][a] = true;
        }

        // 아이스크림 3가지 선택
        res = combination();
        System.out.println(res);

    }

    static public int combination() {

        int cnt = 0;

        for (int i = 1; i < N + 1; i++) {
            for (int j = i + 1; j < N + 1; j++) {
                for (int k = j + 1; k < N + 1; k++) {
                    if (check(i, j, k))
                        cnt++;
                }
            }
        }
        return cnt;
    }

    static public boolean check(int num1, int num2, int num3) {
        if (imposs[num1][num2] || imposs[num1][num3] || imposs[num2][num3]) {
            return false;
        } else
            return true;
    }
}