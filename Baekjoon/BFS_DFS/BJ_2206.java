package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2206 {
    /*
     * 백준 2206
     * 벽 부수고 이동하기
     * (success case)
     */
    static int N, M;
    static int[][] map;
    static boolean[][][] visited; // 3차원 -> 벽을 부순 경우와 부수지 않은 경우
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    static public class Loca {
        int r;
        int c;
        int dis;
        boolean broken;

        public Loca(int r, int c, int dis, boolean broken) {
            this.r = r;
            this.c = c;
            this.dis = dis;
            this.broken = broken;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1][2];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j - 1) - 48;
            }
        }

        int res = bfs();
        System.out.println(res);

    }

    public static int bfs() {
        Queue<Loca> que = new LinkedList<>();
        que.add(new Loca(1, 1, 1, false));
        visited[1][1][0] = true; // 0은 부수지 않은 경우, 1은 부순 경우

        while (!que.isEmpty()) {
            Loca pos = que.poll();
            if (pos.r == N && pos.c == M) {
                // 도착했으면
                return pos.dis;
            }

            for (int d = 0; d < 4; d++) {
                int nr = pos.r + dr[d];
                int nc = pos.c + dc[d];
                if (nr <= 0 || nc <= 0 || nr > N || nc > M) {
                    continue;
                }

                // 벽을 부순적이 있는지 확인
                if (pos.broken) {
                    if (map[nr][nc] == 0 && !visited[nr][nc][1]) {
                        que.add(new Loca(nr, nc, pos.dis + 1, true));
                        visited[nr][nc][1] = true;
                    }
                } else {
                    // 벽이라면
                    if (map[nr][nc] == 1) {
                        visited[nr][nc][1] = true;
                        que.add(new Loca(nr, nc, pos.dis + 1, true));
                    } else if (map[nr][nc] == 0 && !visited[nr][nc][0]) {
                        visited[nr][nc][0] = true;
                        que.add(new Loca(nr, nc, pos.dis + 1, false));
                    }
                }

            }
        }

        return -1;

    }
}
