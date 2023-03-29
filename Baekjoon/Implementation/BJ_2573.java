package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2573 {
    /*
     * 백준 2573
     * 빙산
     */

    // 메모리 초과??? : bfs -> dfs로 해결!

    static int N, M, year;
    static int[][] map, zero;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 }; // 상하좌우
    static boolean[][] visited;

    static class Loca {
        int x;
        int y;

        public Loca(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        year = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        search();
        System.out.println(year);
    }

    public static void search() {

        zero = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (map[i][j] <= 0)
                    continue;

                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] <= 0)
                        zero[i][j]++;
                }
            }
        }
        melting();

        int dummy = 0;
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visited[i][j]) {
                    dfs(i, j);
                    dummy++;
                }
            }
        }

        year++;

        if (dummy >= 2)
            return;
        else if (dummy == 0) {
            year = 0;
            return;
        } else
            search();

    }

    public static void melting() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0)
                    map[i][j] -= zero[i][j];
            }
        }

    }

    public static void dfs(int r, int c) {
        visited[r][c] = true;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] > 0 &&
                    !visited[nr][nc])
                dfs(nr, nc);
        }
    }
}
