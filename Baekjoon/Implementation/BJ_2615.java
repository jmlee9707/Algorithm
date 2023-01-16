package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2615 {
    /*
     * 백준 2615
     * 오목
     */
    public static String[][] board; // 오목판
    public static int[] res; // 결과, 0 : 가로, 1 : 세로
    public static int[] dr = { -1, 0, 1, 1 }; // 우상, 우, 우하, 하
    public static int[] dc = { 1, 1, 1, 0 };
    public static int winner, cnt;

    // 반례 조심!
    // 한지점에 오목과 육목이 겹쳐 있는 경우가 있음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new String[19][19]; // 오목판 19 * 19
        for (int i = 0; i < 19; i++) {
            board[i] = br.readLine().split(" ");
        }
        winner = 0; // 승자 파악 위함. 0일 경우 결론이 나지 않음
        res = new int[2];

        outer: for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) { // 좌측 상단에서 우측 하단 순으로 탐색
                int num = Integer.parseInt(board[j][i]); // 1이면 검은, 2면 흰색알
                if (num == 1 || num == 2) {
                    // 돌이 있을 경우 방향 탐색 시작!
                    for (int d = 0; d < 4; d++) {
                        cnt = 1; // 돌 하나 있으니까
                        check(j, i, num, d);
                        if (cnt == 5 && isFive(j, i, num, d)) {
                            winner = num;
                            res[0] = j + 1;
                            res[1] = i + 1;
                            break outer;
                        }
                    }
                }
            }
        }
        System.out.println(winner);
        if (winner != 0) {
            System.out.println(res[0] + " " + res[1]);
        }

    }

    public static void check(int r, int c, int color, int d) {
        // 돌이 있는지 없는지 탐색 시작!
        int nr = r + dr[d];
        int nc = c + dc[d];
        if (nr >= 0 && nc >= 0 && nr < 19 && nc < 19 && Integer.parseInt(board[nr][nc]) == color) {
            // 바둑알의 색이 같음
            cnt++;
            check(nr, nc, color, d);
            return;
        }

    }

    public static boolean isFive(int r, int c, int color, int d) {
        int nr = r - dr[d];
        int nc = c - dc[d];
        if (nr >= 0 && nc >= 0 && nr < 19 && nc < 19 && Integer.parseInt(board[nr][nc]) == color) {
            return false;
        } else {
            return true;
        }
    }
}
