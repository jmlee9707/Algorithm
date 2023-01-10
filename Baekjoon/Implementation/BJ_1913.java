package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BJ_1913 {
    /*
     * 백준 1913
     * 달팽이
     * 시간 초과 주의...
     */
    static int n, m;
    static int[] dr = { 1, 0, -1, 0 }; // 하 우 상 좌
    static int[] dc = { 0, 1, 0, -1 };
    static int[][] map;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        map = new int[n][n];

        int r = 0;
        int c = 0;
        int resR = 0;
        int resC = 0;

        int dir = 0; // 방향키

        map[0][0] = n * n;

        while (true) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr >= 0 && nc >= 0 && nr < n && nc < n && map[nr][nc] == 0) {
                map[nr][nc] = map[r][c] - 1;
                if (map[nr][nc] == 1)
                    break;
                r = nr;
                c = nc;

            } else {
                dir = (dir + 1) % 4;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == m) {
                    resR = i + 1;
                    resC = j + 1;
                }
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(resR + " " + resC);
        System.out.println(sb);
    }
}
