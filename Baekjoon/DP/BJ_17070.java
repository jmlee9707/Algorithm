package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_17070 {
    /*
     * 백준 17070
     * 파이프 옮기기 1
     */
    static int N, res;
    static int[][] map, dp;
    static boolean[][] visited;
    static Stack<Pipe> stack;
    static int[] dr = { 0, 1, 1 }; // 우, 우하, 하
    static int[] dc = { 1, 1, 0 };

    static class Pipe {
        int type, er, ec;

        public Pipe(int type, int er, int ec) {
            this.type = type;
            this.er = er;
            this.ec = ec;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        res = 0;
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dfs
        // type 1: 가로, 2 : 대각선, 3 : 세로
        stack = new Stack<>();
        // dp[1][2] = 1;
        visited[1][1] = true;
        visited[1][2] = true;
        visited[2][1] = true;

        dfs(new Pipe(1, 1, 2)); //
        System.out.println(res);

    }

    public static void dfs(Pipe p) {

        Pipe prev = p;
        if (prev.er == N && prev.ec == N) {
            res++;
            return;
        }
        for (int d = 0; d < 3; d++) {
            if (prev.type == 1 && d == 2)
                continue;
            if (prev.type == 3 && d == 0)
                continue;

            int nr = prev.er + dr[d];
            int nc = prev.ec + dc[d];
            // System.out.println("현재 위치 x:" + prev.er + " , y : " + prev.ec + " 이전방향 : " +
            // prev.type);
            // System.out.println("다음 위치 x:" + nr + " , y : " + nc + " 이동방향 : " + d);
            if (nr <= 0 || nc > N || nr > N || nc <= 0 || visited[nr][nc] || map[nr][nc] == 1)
                continue;
            if (d == 1) {
                if (prev.er + 1 > N || prev.ec + 1 > N || map[prev.er + 1][prev.ec] == 1
                        || map[prev.er][prev.ec + 1] == 1)
                    continue;
            }

            dfs(new Pipe(d + 1, nr, nc));

        }
        return;
    }
}
