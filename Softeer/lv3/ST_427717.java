package Softeer.lv3;

import java.io.*;
import java.util.*;

public class ST_427717 {
    /*
     * softeer
     * [HSAT 7회 정기 코딩 인증평가 기출] 순서대로 방문하기
     */
    static int N, M, res;
    static int[][] map;
    static Loca[] point;
    static boolean[][] visited;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    static public class Loca {
        int x, y;

        public Loca(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        point = new Loca[M + 1];
        point[0] = new Loca(0, 0);
        res = 0;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            point[i] = new Loca(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Loca l = point[1];

        visited[l.x][l.y] = true;
        move(point[1], 2, visited);
        System.out.println(res);

    }

    public static void move(Loca now, int targetPoint, boolean[][] visit) {
        Loca target = point[targetPoint];

        if (now.x == target.x && now.y == target.y) {
            if (targetPoint == M) {
                res++;
                return;
            } else {
                move(now, targetPoint + 1, visit);
                return;
            }
        }

        for (int d = 0; d < 4; d++) {
            int nr = now.x + dr[d];
            int nc = now.y + dc[d];

            if (nr >= 1 && nr <= N && nc >= 1 && nc <= N && !visit[nr][nc] && map[nr][nc] != 1) {
                visit[nr][nc] = true;
                move(new Loca(nr, nc), targetPoint, visit);
                visit[nr][nc] = false;
            }
        }
    }

}
