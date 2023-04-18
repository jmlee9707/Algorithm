package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2638 {
    /*
     * 백준 2638 치즈
     */
    static public int N, M, time, cheese;
    static public int[][] map;

    static public class Loca {
        int x;
        int y;

        public Loca(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static public int[] dr = { -1, 1, 0, 0 };
    static public int[] dc = { 0, 0, -1, 1 };
    static public Queue<Loca> outCheck;
    static public Queue<Loca> meltCheck;
    static public boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        time = 0;
        cheese = 0; // 치즈 개수

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    cheese++;
            }
        }
        outCheck = new LinkedList<>();
        meltCheck = new LinkedList<>();

        // ==== 입력 끝
        while (cheese > 0) {
            outCheck.clear();
            visited = new boolean[N][M];
            isOutside(0, 0); // 바깥쪽 체크
            canMelt();
            time++;
        }
        System.out.println(time);
    }

    public static void isOutside(int r, int c) {
        // 바깥쪽인지 체크
        Queue<Loca> check = new LinkedList<>();
        check.add(new Loca(0, 0));
        visited[0][0] = true;

        while (!check.isEmpty()) {
            Loca loca = check.poll();
            for (int d = 0; d < 4; d++) {
                int nr = loca.x + dr[d];
                int nc = loca.y + dc[d];
                if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc]) {
                    if (map[nr][nc] == 0)
                        check.add(new Loca(nr, nc));
                    else
                        outCheck.add(new Loca(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
    }

    public static void canMelt() {
        while (!outCheck.isEmpty()) {
            Loca loca = outCheck.poll();
            int cnt = 0;
            for (int d = 0; d < 4; d++) {
                int nr = loca.x + dr[d];
                int nc = loca.y + dc[d];
                if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 0 && visited[nr][nc])
                    cnt++;
            }

            if (cnt >= 2) // 외부의 공기와 접촉해야만 함
                meltCheck.add(new Loca(loca.x, loca.y));
        }

        if (meltCheck.size() != 0) {
            while (!meltCheck.isEmpty()) {
                Loca loca = meltCheck.poll();
                map[loca.x][loca.y] = 0;
                cheese--;
            }
        }
    }
}
