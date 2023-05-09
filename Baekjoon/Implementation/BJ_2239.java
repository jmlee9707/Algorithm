package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2239 {
    /*
     * 백준 2239
     * 스도쿠
     */
    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // --- 입력 끝!

    }

    public static void checkVertical(int r, int c) {
        boolean[] num = new boolean[10];

        for (int i = 0; i < 9; i++) {

        }
    }
}
