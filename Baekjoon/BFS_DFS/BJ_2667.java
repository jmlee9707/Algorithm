package Baekjoon.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BJ_2667
 * 단지 번호 붙이기
 */
public class BJ_2667 {
    static int N, cnt;
    static int[][] map;
    static boolean[][] visited;
    static int[] aparts = new int[25 * 25]; // maxium
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {

                map[i][j] = s.charAt(j) - '0';
            }
        }

        // ======== input end =========

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        Arrays.sort(aparts);
        System.out.println(cnt);

        for (int i = aparts.length - cnt; i < aparts.length; i++) {
            System.out.println(aparts[i]);
        }

    }

    public static void dfs(int r, int c) {
        visited[r][c] = true;
        aparts[cnt]++; // first

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nc >= 0 && nr < N && nc < N && visited[nr][nc] == false && map[nr][nc] == 1) {
                dfs(nr, nc);
            }
        }
    }

}