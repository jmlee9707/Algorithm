package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7569 {
    static int M, N, H, res, none; // 상자의 크기, 결과값, 안익은 토마토의 개수
    static int[][][] box;

    static int[] dr = { -1, 0, 1, 0, 0, 0 };
    static int[] dc = { 0, 1, 0, -1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, 1, -1 };

    // 토마토
    static public class Location {
        int r, c, z;

        public Location(int r, int c, int z) {
            super();
            this.r = r;
            this.c = c;
            this.z = z;
        }
    }

    static Queue<Location> que = new LinkedList<Location>(); // 익은 토마토 넣기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이

        box = new int[N][M][H];
        res = 0;
        none = 0;

        // 1: 익힌 토마토
        // 0 : 익지 않은 토마토
        // -1 : 빈 박스

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    box[j][k][i] = Integer.parseInt(st.nextToken());
                    if (box[j][k][i] == 1)
                        que.add(new Location(j, k, i));
                    else if (box[j][k][i] == 0)
                        none++;
                }
            }

        }

        if (none == 0)
            res = 0;
        else
            bfs();

        System.out.println(res);

    }

    public static void bfs() {
        while (!que.isEmpty()) {
            int count = que.size();
            for (int i = 0; i < count; i++) {
                Location loca = que.poll();
                for (int j = 0; j < 6; j++) {
                    int nr = loca.r + dr[j];
                    int nc = loca.c + dc[j];
                    int nz = loca.z + dz[j];
                    if (nr >= 0 && nc >= 0 && nr < N && nc < M && nz >= 0 && nz < H && box[nr][nc][nz] == 0) {
                        box[nr][nc][nz] = 1;
                        none--;
                        que.add(new Location(nr, nc, nz));
                    }
                }
            }

            res++;
            if (none == 0)
                return;
        }
        res = -1;
        return;
    }
}