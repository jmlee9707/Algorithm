package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2589 {
    /*
     * 백준 2589
     * 보물섬
     */
    static int R, C, hour;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 }; // 상하좌우

    static class Loca {
        int r;
        int c;

        public Loca(int r, int c) {
            this.r = r;
            this.c = c;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        R = Integer.parseInt(temp.split(" ")[0]);
        C = Integer.parseInt(temp.split(" ")[1]);

        map = new char[R][C];

        hour = 0; // 시간
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                visited = new boolean[R][C];
                if (map[i][j] == 'L')
                    bfs(i, j); // 시작점이 보물
            }
        }

        System.out.println(hour - 1);
    }

    public static void bfs(int sr, int sc) {
        int cnt = 0;
        Queue<Loca> que = new LinkedList<>();
        que.add(new Loca(sr, sc));
        visited[sr][sc] = true;

        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                Loca l = que.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = l.r + dr[d];
                    int nc = l.c + dc[d];
                    if (nr >= 0 && nc >= 0 && nr < R && nc < C && !visited[nr][nc] && map[nr][nc] == 'L') {
                        que.add(new Loca(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
            }
            cnt++;

        }

        hour = Math.max(hour, cnt);
        return;
    }
}
