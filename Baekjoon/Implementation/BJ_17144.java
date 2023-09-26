package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17144 {
    /*
     * 백준 17144
     * 미세먼지 안녕!
     */
    static int R, C, T, dust; // dust : 미세먼지의 양
    static int[][] map;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int[] airLoca = new int[2];

    static class Loca {
        int r;
        int c;
        int fine; // 미세먼지의 양

        public Loca(int r, int c, int fine) {
            this.r = r;
            this.c = c;
            this.fine = fine;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (airLoca[0] == 0)
                        airLoca[0] = i;
                    else
                        airLoca[1] = i;
                }
            }
        }

        while (T > 0) {
            diffusion(); // 미세먼지 확산
            T--; // 시간 줄이기
        }

        calcDust(); // 미세먼지 양 계산
        System.out.println(dust);
    }

    public static void diffusion() {
        Queue<Loca> que = new LinkedList<>(); // 기존에 있었던 양
        // Loca airTop = new Loca(-1, -1, -1); // 임시 값

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    int cnt = 0;
                    Queue<Loca> dir = new LinkedList<>(); // 새로운 양
                    for (int d = 0; d < 4; d++) { // 확산된 방향 개수 세기
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] != -1) {
                            cnt++;
                            dir.add(new Loca(nr, nc, 0));
                        }
                    }

                    int fineDust = map[i][j] / 5;
                    que.add(new Loca(i, j, map[i][j] - fineDust * cnt));

                    while (!dir.isEmpty()) { // 확산되는 양
                        Loca lo = dir.poll();
                        que.add(new Loca(lo.r, lo.c, fineDust));
                    }

                    map[i][j] = 0;
                }
            }
        }

        while (!que.isEmpty()) {
            Loca l = que.poll();
            map[l.r][l.c] += l.fine; // 미세먼지 확산 끝!
        }

        runAirCleaner(); // 공기청정기 작동
    }

    public static void runAirCleaner() {
        turnTop();
        turnBottom();
    }

    public static void turnTop() {
        // 위에서 아래
        int x = airLoca[0];
        int y = C - 1;
        for (int r = x - 1; r > 0; r--) {
            map[r][0] = map[r - 1][0];
        }
        for (int c = 0; c < y; c++) {
            map[0][c] = map[0][c + 1];
        }
        for (int r = 0; r < x; r++) {
            map[r][y] = map[r + 1][y];
        }
        for (int c = y; c > 0; c--) {
            map[x][c] = map[x][c - 1];
        }
        map[x][1] = 0;
        return;
    }

    public static void turnBottom() {
        int sx = airLoca[1];
        // int sy = 0;
        int ex = R - 1;
        int ey = C - 1;

        for (int r = sx + 1; r < ex; r++) {
            map[r][0] = map[r + 1][0];
        }
        for (int c = 0; c < ey; c++) {
            map[ex][c] = map[ex][c + 1];
        }
        for (int r = ex; r > sx; r--) {
            map[r][ey] = map[r - 1][ey];
        }
        for (int c = ey; c > 0; c--) {
            map[sx][c] = map[sx][c - 1];
        }

        map[sx][1] = 0;

    }

    public static void calcDust() {
        dust = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != -1)
                    dust += map[i][j];
            }
        }
        return;
    }
}
