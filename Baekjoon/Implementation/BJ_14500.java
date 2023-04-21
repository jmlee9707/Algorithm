package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14500 {
    /*
     * 백준 14500
     * 테트로미노
     */
    public static int N, M, max;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dr = { -1, 1, 0, 0 };
    public static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // useImple(i, j); // 19가지 경우의 수 구현....
                useDfs(i, j);
            }
        }

        System.out.println(max);

    }

    public static void useImple(int i, int j) {
        check1(i, j);
        check2(i, j);
        check3(i, j);
        check4(i, j);
        check5(i, j);
    }

    public static void useDfs(int r, int c) {
        // 깊이가 4가 될떄까지 탐색한 결과를 구한 뒤 ㅗ 모양의 테트로미노는 따로 구하기~

        visited[r][c] = true;
        dfs(r, c, 0, map[r][c]);
        check5(r, c);
        visited[r][c] = false;
    }

    public static void dfs(int r, int c, int cnt, int sum) {
        if (cnt == 3) {
            max = Math.max(sum, max);
            return;
        }
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(nr, nc, cnt + 1, sum + map[nr][nc]);
                visited[nr][nc] = false;
            }
        }
    }

    public static void check1(int r, int c) {
        if (r + 3 < N) {
            max = Math.max(map[r][c] + map[r + 1][c] + map[r + 2][c] + map[r + 3][c], max);
        }
        if (c + 3 < M) {
            max = Math.max(map[r][c] + map[r][c + 1] + map[r][c + 2] + map[r][c + 3], max);
        }
    }

    public static void check2(int r, int c) {
        if (r + 1 < N && c + 1 < M) {
            max = Math.max(map[r][c] + map[r + 1][c] + map[r][c + 1] + map[r + 1][c + 1], max);
        }
    }

    public static void check3(int r, int c) {
        // L 자 모양

        if (r - 2 >= 0 && c - 1 >= 0) {
            max = Math.max(map[r][c] + map[r][c - 1] + map[r - 1][c - 1] + map[r - 2][c - 1], max); // 1
        }
        if (r + 1 < N && c + 2 < M) { // r
            max = Math.max(map[r][c] + map[r + 1][c] + map[r + 1][c + 1] + map[r + 1][c + 2], max); // 5

        }
        if (r - 2 >= 0 && c + 1 < M) {
            max = Math.max(map[r][c] + map[r][c + 1] + map[r - 1][c + 1] + map[r - 2][c + 1], max); // 2
        }
        if (r - 1 >= 0 && c - 2 >= 0) {
            max = Math.max(map[r][c] + map[r - 1][c] + map[r - 1][c - 1] + map[r - 1][c - 2], max); // 3
        }
        if (c + 2 < M && r - 1 >= 0) {
            max = Math.max(map[r][c] + map[r - 1][c] + map[r - 1][c + 1] + map[r - 1][c + 2], max); // 4
        }
        if (r + 2 < N && c - 1 >= 0) {
            max = Math.max(map[r][c] + map[r][c - 1] + map[r + 1][c - 1] + map[r + 2][c - 1], max); // 6
        }
        if (r + 2 < N && c + 1 < M) {
            max = Math.max(map[r][c] + map[r][c + 1] + map[r + 1][c + 1] + map[r + 2][c + 1], max); // 7
        }
        if (c - 2 >= 0 && r + 1 < N) {
            max = Math.max(map[r][c] + map[r + 1][c] + map[r + 1][c - 1] + map[r + 1][c - 2], max); // 8
        }

    }

    public static void check4(int r, int c) {

        if (r + 2 < N && c + 1 < M) {
            max = Math.max(map[r][c] + map[r + 1][c] + map[r + 1][c + 1] + map[r + 2][c + 1], max);
        }
        if (r + 2 < N && c - 1 >= 0) {
            max = Math.max(map[r][c] + map[r + 1][c] + map[r + 1][c - 1] + map[r + 2][c - 1], max);
        }
        if (r + 1 < N && c + 2 < M) {
            max = Math.max(map[r][c] + map[r][c + 1] + map[r + 1][c + 1] + map[r + 1][c + 2], max);
        }
        if (r - 1 >= 0 && c + 2 < M) {
            max = Math.max(map[r][c] + map[r][c + 1] + map[r - 1][c + 1] + map[r - 1][c + 2], max);
        }
    }

    public static void check5(int r, int c) {
        if (r - 1 >= 0 && c + 1 < M && c - 1 >= 0) {
            max = Math.max(map[r][c] + map[r - 1][c] + map[r - 1][c - 1] + map[r - 1][c + 1], max);
        }
        if (r + 1 < N && c + 1 < M && c - 1 >= 0) {
            max = Math.max(map[r][c] + map[r + 1][c] + map[r + 1][c - 1] + map[r + 1][c + 1], max);
        }
        if (c - 1 >= 0 && r + 1 < N && r - 1 >= 0) {
            max = Math.max(map[r][c] + map[r][c - 1] + map[r - 1][c - 1] + map[r + 1][c - 1], max);
        }
        if (r - 1 >= 0 && r + 1 < N && c + 1 < M) {
            max = Math.max(map[r][c] + map[r - 1][c + 1] + map[r][c + 1] + map[r + 1][c + 1], max);
        }
    }

}
