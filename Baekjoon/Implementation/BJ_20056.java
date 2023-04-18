package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_20056 {
    /*
     * 백준 20056
     * 마법사 상어와 파이어볼
     */
    static public int N, M, K, res;
    static public LinkedList<Fireball>[][] map;
    static public int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static public int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

    static public class Fireball {
        int r;
        int c;
        int m; // 질량
        int s; // 속력
        int d; // 방향

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static public Queue<Fireball> waitList; // 이동 대기중인 파이어볼들

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        waitList = new LinkedList<>();
        res = 0;
        map = new LinkedList[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            waitList.add(new Fireball(r - 1, c - 1, m, s, d));
        }

        for (int i = 0; i < K; i++) {
            moving(); // 이동!
        }

        // 질량 계산하기~
        while (!waitList.isEmpty()) {
            Fireball b = waitList.poll();
            res += b.m;
        }

        System.out.println(res);
    }

    public static void moving() {

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = new LinkedList<>();
            }
        }

        while (!waitList.isEmpty()) {
            Fireball f = waitList.poll();
            int nr = f.r + dr[f.d] * f.s;
            int nc = f.c + dc[f.d] * f.s;
            if (nr >= N)
                nr = nr % N;
            if (nc >= N)
                nc = nc % N;

            while (nr < 0)
                nr += N;
            while (nc < 0)
                nc += N;

            map[nr][nc].add(new Fireball(nr, nc, f.m, f.s, f.d));
        }

        combine();

    }

    public static void combine() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() == 1) {
                    Fireball f = map[i][j].getFirst();
                    if (f.m != 0)
                        waitList.add(f);
                } else if (map[i][j].size() >= 2) {
                    int sumM = 0;
                    int sumS = 0;
                    int allD = map[i][j].getFirst().d % 2;
                    boolean dirCheck = true;

                    for (int k = 0; k < map[i][j].size(); k++) {
                        Fireball f = map[i][j].get(k);
                        sumM += f.m;
                        sumS += f.s;
                        if (allD != f.d % 2)
                            dirCheck = false;
                    }

                    sumM /= 5;
                    sumS /= map[i][j].size();

                    if (sumM == 0)
                        continue; // 질량이 0이면 사라짐

                    if (dirCheck) {
                        waitList.add(new Fireball(i, j, sumM, sumS, 0));
                        waitList.add(new Fireball(i, j, sumM, sumS, 2));
                        waitList.add(new Fireball(i, j, sumM, sumS, 4));
                        waitList.add(new Fireball(i, j, sumM, sumS, 6));
                    } else {
                        waitList.add(new Fireball(i, j, sumM, sumS, 1));
                        waitList.add(new Fireball(i, j, sumM, sumS, 3));
                        waitList.add(new Fireball(i, j, sumM, sumS, 5));
                        waitList.add(new Fireball(i, j, sumM, sumS, 7));
                    }
                }
            }
        }
    }

}
