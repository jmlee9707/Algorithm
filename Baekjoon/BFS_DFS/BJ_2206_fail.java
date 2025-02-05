package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2206_fail {
    /*
     * 백준 2206
     * 벽 부수고 이동하기
     * (시간초과 나는 case)
     */
    static int N, M, res;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static Queue<Loca> wall, que;

    static public class Loca {
        int r;
        int c;
        int dis;

        public Loca(int r, int c, int dis) {
            this.r = r;
            this.c = c;
            this.dis = dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        wall = new LinkedList<>();
        map = new int[N + 1][M + 1];
        res = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j - 1) - 48;
                if (map[i][j] == 1) {
                    wall.add(new Loca(i, j, 1));
                }
            }
        }

        bfs();
        while (!wall.isEmpty()) {
            Loca pos = wall.poll();
            map[pos.r][pos.c] = 0; // 임시로 벽 부수기

            bfs();

            map[pos.r][pos.c] = 1; // 벽 원상복귀
        }

        // O(N^2M^2) 만큼의 시간이 소요된다 -> 시간초과 발생

        System.out.println(res == Integer.MAX_VALUE ? -1 : res);

    }

    public static void bfs() {
        que = new LinkedList<>();
        que.add(new Loca(1, 1, 1));
        visited = new boolean[N + 1][M + 1];
        visited[1][1] = true;

        while (!que.isEmpty()) {
            Loca pos = que.poll();
            if (pos.r == N && pos.c == M) {
                // 도착했으면
                res = Math.min(res, pos.dis);
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = pos.r + dr[d];
                int nc = pos.c + dc[d];
                if (nr > 0 && nc > 0 && nr <= N && nc <= M && !visited[nr][nc] && map[nr][nc] == 0) {
                    que.add(new Loca(nr, nc, pos.dis + 1));
                    visited[nr][nc] = true;
                }
            }
        }

        return;

    }
}
