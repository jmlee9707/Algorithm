package Programmers;

import java.util.*;

public class Solution_17679 {

    // 프로그래머스
    // 프렌즈 4블록
    // 2018 kakao blind 문제

    public static String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
    public static int[] dr = { 0, 1, 1 }; // 우 우하 하
    public static int[] dc = { 1, 1, 0 };
    public static int res;
    public static char[][] map;

    public static class Loca {
        int r;
        int c;

        public Loca(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        res = sol(4, 5, board);
        System.out.println(res);
        String name;
        name.substring(res, res)
    }

    public static int sol(int m, int n, String[] board) {
        res = 0;
        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            if (!checkBreak(4, 5)) {
                break;
            }
            System.out.println(res);
        }

        return res;
    }

    public static boolean checkBreak(int m, int n) {
        Queue<Loca> que = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                char temp = map[i][j];
                Queue<Loca> same = new LinkedList<>();
                if (temp == '.')
                    continue;

                for (int d = 0; d < 3; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && map[nr][nc] == temp) {
                        cnt++;
                        same.add(new Loca(nr, nc));
                    } else
                        break;
                }

                if (cnt == 3) {
                    que.add(new Loca(i, j));
                    while (!same.isEmpty())
                        que.add(same.poll());
                }
            }
        }

        if (que.isEmpty())
            return false;
        else {
            while (!que.isEmpty()) {
                Loca loca = que.poll();
                if (map[loca.r][loca.c] != '.') {
                    map[loca.r][loca.c] = '.';
                    res++;
                }
            }
            moveDown(4, 5);
        }
        return true;

    }

    static public void moveDown(int m, int n) {
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                if (map[i][j] == '.') {
                    outer: for (int k = i - 1; k >= 0; k--) {
                        if (map[k][j] != '.') {
                            map[i][j] = map[k][j];
                            map[k][j] = '.';
                            break outer;
                        }
                    }
                }
            }
        }
    }

}