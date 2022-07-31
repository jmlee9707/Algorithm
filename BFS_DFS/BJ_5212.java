package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_5212 {
    static int R, C, minR, minC, maxR, maxC;
    static char[][] map;
    static boolean[][] visit;
    static int dr[] = { -1, 1, 0, 0 }; // 상하좌우
    static int dc[] = { 0, 0, -1, 1 };
    static Queue<Location> que;

    static public class Location {
        int r;
        int c;

        public Location(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 입력 받기
        map = new char[R + 1][C + 1];
        visit = new boolean[R + 1][C + 1]; // 방문 체크
        que = new LinkedList<Location>();
        for (int i = 1; i <= R; i++) {
            String s = br.readLine();
            for (int j = 1; j <= C; j++) {
                map[i][j] = s.charAt(j - 1);
                if (map[i][j] == 'X') {
                    que.add(new Location(i, j));
                    visit[i][j] = true;
                }
            }
        }
        minR = minC = 11;
        maxR = maxC = 0;
        bfs();

        for (int i = minR; i <= maxR; i++) {
            for (int j = minC; j <= maxC; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }

    public static void bfs() {
        while (!que.isEmpty()) {
            Location loca = que.poll();
            int sea = 0;
            int ground = 0;

            for (int i = 0; i < 4; i++) {
                int nr = loca.r + dr[i];
                int nc = loca.c + dc[i];
                if (nr > 0 && nc > 0 && nr <= R && nc <= C) {
                    ground++;
                    if (!visit[nr][nc] && map[nr][nc] == '.') {
                        sea++;
                    }
                }
            }
            if (ground - sea <= 1) {
                map[loca.r][loca.c] = '.'; // 바다로 변신~
            } else {
                minR = loca.r < minR ? loca.r : minR;
                minC = loca.c < minC ? loca.c : minC;
                maxR = loca.r > maxR ? loca.r : maxR;
                maxC = loca.c > maxC ? loca.c : maxC;
            }
        }
    }
}
