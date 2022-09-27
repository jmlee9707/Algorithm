package Baekjoon.BFS_DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_4963 {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 상하좌우 좌상우상 좌하좌우
    static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0)
                break; // end

            map = new int[h][w];
            int res = 0;
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        res++;
                    }
                }
            }

            bw.write(res + "\n");
        }

        bw.flush();
        bw.close();
    }

    static public void dfs(int r, int c) {
        visited[r][c] = true;

        for (int i = 0; i < 8; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 && nr < h && nc < w && map[nr][nc] == 1 && !visited[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }
}
