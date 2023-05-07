package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_6593 {
    /*
     * 백준 6593
     * 상범 빌딩
     */
    static int L, R, C; // 상범 빌딩의 층 수, 행, 열
    static char[][][] building; // 상범 빌딩
    static boolean isEscape; // 탈출 가능 여부
    static int minute;
    static Loca start;
    static boolean[][][] isVisited; // 방문여부
    static int[] dl = { 0, 0, 0, 0, -1, 1 }; // 동서남북 상하
    static int[] dr = { 0, 0, -1, 1, 0, 0 };
    static int[] dc = { -1, 1, 0, 0, 0, 0 };

    static class Loca {
        int l;
        int r;
        int c;
        int t; // 시간

        public Loca(int l, int r, int c, int t) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0)
                break;

            building = new char[L][R][C]; // 빌딩 건설1
            isEscape = true;

            for (int i = 0; i < L; i++) { // 빌딩 입력문
                for (int j = 0; j < R; j++) {
                    String str = br.readLine();
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = str.charAt(k);
                        if (building[i][j][k] == 'S')
                            start = new Loca(i, j, k, 0);
                    }
                }
                br.readLine();
            }

            isEscape = bfs(start.l, start.r, start.c, start.t);

            // 출력문
            if (isEscape) {
                System.out.println("Escaped in " + minute + " minute(s).");
            } else
                System.out.println("Trapped!");
        }

    }

    public static boolean bfs(int l, int r, int c, int t) {
        Queue<Loca> que = new LinkedList<>();
        isVisited = new boolean[L][R][C];

        que.add(new Loca(l, r, c, t)); // 처음 방문
        isVisited[l][r][c] = true;
        minute = 0;

        while (!que.isEmpty()) {
            Loca loca = que.poll();

            for (int d = 0; d < 6; d++) {
                int nl = loca.l + dl[d];
                int nr = loca.r + dr[d];
                int nc = loca.c + dc[d];

                if (nl >= 0 && nl < L && nr >= 0 && nr < R && nc >= 0 && nc < C && building[nl][nr][nc] != '#'
                        && !isVisited[nl][nr][nc]) {
                    if (building[nl][nr][nc] == 'E') {
                        minute = loca.t + 1;
                        return true;
                    }

                    que.add(new Loca(nl, nr, nc, loca.t + 1));
                    isVisited[nl][nr][nc] = true;
                }
            }

        }
        return false;
    }
}
