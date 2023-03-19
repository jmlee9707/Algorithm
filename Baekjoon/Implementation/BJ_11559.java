package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_11559 {
    /*
     * 백준 11559
     * puyo puyo
     */
    static char[][] map;
    static int res = 0;
    static boolean canPuyo = false;
    static boolean[][] visited;
    static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
    static int[] dc = { 0, 0, -1, 1 };
    static Queue<Puyo> delePu;
    static LinkedList<Puyo> list;

    static class Puyo {
        int r;
        int c;
        int color;

        public Puyo(int r, int c, int color) {
            this.r = r;
            this.c = c;
            this.color = color;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[12][6];

        for (int i = 0; i < 12; i++) {
            map[i] = br.readLine().toCharArray();
        }

        res = 0;

        // 1. 연쇄 작용 되는지 확인 -> 가능한 뿌요 모두 터뜨리기
        // 2. 터트린 후 남은 뿌요를 아래로 내리기
        // 3. 연쇄 횟수 1증가
        // 4. 연쇄 작용이 발생하지 않은 경우 종료

        while (true) {

            check(); // 연쇄 작용이 되는지 안되는지 확인

            if (!canPuyo) {
                System.out.println(res);
                break;
            } else {
                bomb();
                res++; // 연쇄 작용++
            }
        }
    }

    public static void check() {

        visited = new boolean[12][6];
        canPuyo = false;
        // 연쇄 작용이 일어나야 하는 애들 list
        list = new LinkedList<>();

        // 연쇄 작용이 되는지 확인
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (!visited[i][j] && map[i][j] != '.') {
                    delePu = new LinkedList<>();
                    // bfs 여기 확인
                    bfs(i, j, map[i][j]);
                }
            }
        }

    }

    public static void bfs(int r, int c, char color) {
        Queue<Puyo> que = new LinkedList<>();
        que.add(new Puyo(r, c, color));

        // 갯수
        int cnt = 0;

        while (!que.isEmpty()) {
            Puyo puyo = que.poll();
            delePu.add(new Puyo(puyo.r, puyo.c, puyo.color));
            cnt++;
            visited[puyo.r][puyo.c] = true;

            for (int d = 0; d < 4; d++) {
                int nr = puyo.r + dr[d];
                int nc = puyo.c + dc[d];
                if (nr >= 0 && nc >= 0 && nr < 12 && nc < 6 && map[nr][nc] == puyo.color && !visited[nr][nc]) {
                    que.add(new Puyo(nr, nc, color));
                }
            }
        }

        if (cnt >= 4) {
            if (!canPuyo)
                canPuyo = true;

            while (!delePu.isEmpty())
                list.add(delePu.poll());
        }

    }

    public static void bomb() {
        for (Puyo p : list) {
            map[p.r][p.c] = '.';
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 11; j >= 0; j--) {
                char col = map[j][i];

                if (map[j][i] != '.') {
                    int cnt = 0;
                    for (int k = j; k < 12; k++) {
                        if (k + 1 < 12 && map[k + 1][i] == '.') {
                            cnt++;
                        } else {
                            break;
                        }
                    }

                    if (cnt != 0) {
                        map[j + cnt][i] = col;
                        map[j][i] = '.';
                    }
                }
            }

        }
    }
}
