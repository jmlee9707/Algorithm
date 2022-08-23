package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17086 {
    static int N, M, res, max;
    static int[][] sea;
    static boolean[][] visited;
    static int[] dr = { -1, 1, 0, 0, -1, 1, -1, 1 }; // 상하좌우 좌상 좌하 우상 우하
    static int[] dc = { 0, 0, -1, 1, -1, -1, 1, 1 };

    public static class Location {
        int r;
        int c;
        int cnt;

        public Location(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

    }

    public static void main(String[] args) throws IOException {
        // 아기상어
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        max = 0;
        sea = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (sea[i][j] == 0) {
                    res = bfs(i, j);
                    if (res > max) {
                        max = res;
                    }
                }
            }
        }

        System.out.println(max);
    }

    public static int bfs(int r, int c) {
        visited = new boolean[N][M]; // 매번 초기화
        visited[r][c] = true;
        Queue<Location> que = new LinkedList<Location>();
        que.add(new Location(r, c, 0));

        while (!que.isEmpty()) {
            Location loca = que.poll();
            for (int i = 0; i < 8; i++) {
                // 팔방 탐색
                int nr = loca.r + dr[i];
                int nc = loca.c + dc[i];
                int count = loca.cnt + 1;
                if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc]) {
                    if (sea[nr][nc] == 1) {
                        return count;
                    } else {
                        que.add(new Location(nr, nc, count));
                        visited[nr][nc] = true;
                    }
                }
            }
        }

        return 0;

    }
}
