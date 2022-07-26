package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1012 {
    // 유기농 배추
    static int T, M, N, K, X, Y, res;
    static int[][] map;
    static boolean[][] visited;

    static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
    static int[] dc = { 0, 0, -1, 1 };

    public static class Location {
        int r;
        int c;

        public Location(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static Queue<Location> que;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로길이
            N = Integer.parseInt(st.nextToken()); // 세로길이
            K = Integer.parseInt(st.nextToken()); // 배추 개수

            map = new int[N][M];
            visited = new boolean[N][M];
            que = new LinkedList<Location>();
            for (int k = 1; k <= K; k++) {
                // 배추의 위치
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());
                map[Y][X] = 1; // 배추가 심어져 있음

            }
            // 입력 끝

            res = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] == 1 && !visited[r][c]) {
                        bfs(r, c);
                        res++;
                    }
                }
            }
            System.out.println(res);
        }
    }

    public static void bfs(int y, int x) {
        que.add(new Location(y, x));
        while (!que.isEmpty()) {
            Location loca = que.poll(); // 하나씩 꺼내기
            visited[loca.r][loca.c] = true; // 방문했음!
            for (int i = 0; i < 4; i++) {
                int nr = loca.r + dr[i];
                int nc = loca.c + dc[i];
                if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc] && map[nr][nc] == 1) {
                    que.add(new Location(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }
}
