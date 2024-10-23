package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16928 {
    /*
     * 백준 16928
     * 뱀과 사다리 게임
     */
    static public class Loca {
        int cnt;
        int loca;

        public Loca(int loca, int cnt) {
            this.loca = loca;
            this.cnt = cnt;
        }
    }

    static int[] board = new int[101];
    static int N, M;
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[101];

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        System.out.println(play());

    }

    public static int play() {

        Queue<Loca> que = new LinkedList<>();
        que.add(new Loca(1, 0));
        visited[1] = true;
        while (!que.isEmpty()) {
            Loca l = que.poll();

            for (int i = 1; i <= 6; i++) {
                int nex = l.loca + i;
                if (nex == 100)
                    return l.cnt + 1;
                else if (nex > 100 || visited[nex])
                    continue;

                if (board[nex] != 0) {
                    que.add(new Loca(board[nex], l.cnt + 1));
                    visited[board[nex]] = true;
                } else {
                    // 이동할 곳 X
                    que.add(new Loca(nex, l.cnt + 1));
                    visited[nex] = true;
                }
            }
        }
        return -1;

    }

}
