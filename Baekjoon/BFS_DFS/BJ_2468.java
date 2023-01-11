package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BJ_2468
 * 안전영역
 */
public class BJ_2468 {
    static int n, max;
    static int[][] map;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static boolean[][] visited;

    public static class Loca {
        int r;
        int c;

        public Loca(int r, int c) {
            this.r = r;
            this.c = c;
        }
    };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int maxium = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxium = Math.max(maxium, map[i][j]);
            }
        }

        max = 1; // 안전한 영역이 최대로 몇개?, 아무 지역도 물에 잠기지 않을 수 있음
        // 높이는 1부터 100이하

        for (int i = 1; i <= maxium; i++) {
            // 높이 전달
            visited = new boolean[n][n];
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!visited[j][k] && map[j][k] > i) {
                        bfs(i, j, k);
                        cnt++;
                    }
                }
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }

    static public void bfs(int rain, int x, int y) {
        Queue<Loca> que = new LinkedList<>();
        que.add(new Loca(x, y));
        visited[x][y] = true;

        while (!que.isEmpty()) {
            Loca l = que.poll();
            for (int i = 0; i < 4; i++) {
                int nr = l.r + dr[i];
                int nc = l.c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc] && map[nr][nc] > rain) {
                    que.add(new Loca(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }

}