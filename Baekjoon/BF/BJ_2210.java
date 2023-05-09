package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2210 {
    /*
     * 백준 2210
     * 숫자판 점프
     */
    static char[][] board = new char[5][5];
    static boolean[] num = new boolean[1000000];
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = st.nextToken().charAt(0);
            }
        }
        res = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                move(i, j, 0, "");
            }
        }

        System.out.println(res);
    }

    public static void move(int r, int c, int cnt, String s) {

        if (cnt == 6) {

            int temp = Integer.parseInt(s);
            if (!num[temp]) {
                num[temp] = true;
                res++;
            }
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5) {
                move(nr, nc, cnt + 1, s + board[r][c]);
            }
        }
    }

}
