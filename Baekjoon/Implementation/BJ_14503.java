package Baekjoon.Implementation;

import java.io.*;
import java.util.*;

/**
 * BJ_14503
 * 로봇 청소기
 */

public class BJ_14503 {

    // 로봇 청소기가 주어졌을 때 청소하는 영역의 개수를 구하는 프로그래밍
    static int N, M, res;
    static int lr, lc, ld; // 로봇청소기의 위치, 방향
    static int[] dr = { -1, 0, 1, 0 }; // 상, 우, 하, 좌
    static int[] dc = { 0, 1, 0, -1 }; // 상, 우, 하, 좌
    static int[][] map;
    static boolean[][] visited;

    public static void stepOne() {
        // 청소시작
        // 1. 현재 위치를 청소한다
        if (map[lr][lc] == 0 && !visited[lr][lc]) {
            visited[lr][lc] = true; // 청소하기
            res++;
            stepTwo();
        }
    }

    public static void stepTwo() {

        int check = 0; // 2-3,4을 확인할

        for (int i = 0; i < 4; i++) {
            // 왼쪽 방향부터 확인
            int nd = (ld + 3 - i) % 4;
            int nr = lr + dr[nd];
            int nc = lc + dc[nd];

            if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc] && map[nr][nc] == 0) {
                lr = nr;
                lc = nc;
                ld = nd;
                stepOne();
                break;
            }
            // // 2-2. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
            else {
                // ld = (ld + 3) % 4;
                // 2-3. 네방향 모두 청소가 이미 되어있거나 벽인 경우에는 바라보는 방향을 유지한채로 한칸 후진을 하고 2번으로 돌아간다
                if (nr >= 0 && nc >= 0 && nr < N && nc < M && (map[nr][nc] == 1 || visited[nr][nc])) {
                    check++;
                }
                continue;
            }
        }
        // ======= 1, 2번도 안될떄! ======

        if (check == 4) {
            int nr = lr - dr[ld];
            int nc = lc - dc[ld];
            // 2-4. 네 방향 모두 청소가 이미 되어 있거나 벽이면서, 뒤쪽 방향이 벽이라 추진도 할 수 없는 경우에는 작동을 멈춘다.
            if (nr < 0 || nc < 0 || nr >= N || nc >= M || map[nr][nc] == 1) {
                return;
            } else {
                lr = nr;
                lc = nc;
                stepTwo();
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());

        res = 0;

        lr = Integer.parseInt(st.nextToken());
        lc = Integer.parseInt(st.nextToken());
        ld = Integer.parseInt(st.nextToken());

        // 0은 빈칸, 1은 벽
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                // if (map[i][j] == 0)
                // dirty++;
            }
        }

        // ================ 입력 끝 ======================

        stepOne();
        System.out.println(res);
    }

}
