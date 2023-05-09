package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17135 {
    static int N, M, D, monster, res;
    static int[][] map, copy;
    static int[] dr = { -1, 0, 1 }; // 좌상우
    static int[] dc = { 0, -1, 0 };
    static int[] arrow; // 궁수
    static boolean[] isDone;

    static class Loca {
        int r;
        int c;
        int d;

        public Loca(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }

    }

    public static void main(String[] args) throws IOException {
        // 캐슬디펜스
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        res = 0; // 제거할 수 있는 적의 최대 수
        monster = 0; // 적의 개수

        map = new int[N + 1][M];

        // 0~M-1번 사이에 궁수 3명 배치 => 조합?

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    monster++;
                }
            }
        }

        arrow = new int[3]; // 궁수의 위치
        // 3칸에 궁수 정하기 0~M-1 사이
        combination(0, 0);
        System.out.println(res);
    }

    public static void combination(int cnt, int start) {
        if (cnt == 3) {

            // System.out.println(arrow[0] + " " + arrow[1] + " " + arrow[2]);
            // 궁수자리 정해지면 공격
            copy = mapCopy(); // 지도 복사하기
            attack();
            return;
        }

        for (int i = start; i < M; i++) {
            arrow[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }

    public static int[][] mapCopy() {
        int[][] temp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }

    public static void attack() {
        int turn = N; // 현재 궁수의 위치
        int dis = 0; // 현재 궁수가 적까지의 거리
        int kill = 0;
        Queue<Loca> que = new LinkedList<>(); // 적을 담을 배열

        while (turn > 0) { // N
            dis = 0;
            isDone = new boolean[3];
            for (int i = 0; i < 3; i++) {
                int y = turn;
                int x = arrow[i]; // 궁수의 위치

                int minD = Integer.MAX_VALUE; // 최소거리
                int minR = -1;
                int minC = -1;

                // 공격할 적 찾기
                for (int r = y - 1; r >= 0; r--) {
                    for (int c = 0; c < M; c++) {
                        if (copy[r][c] == 1) {
                            dis = Math.abs(y - r) + Math.abs(x - c); // 거리
                            if (dis > D)
                                continue;

                            if (dis < minD) { // 최단거리 찾기
                                minD = dis;
                                minR = r; //
                                minC = c;
                            } else if (dis == minD) {
                                if (c < minC) {
                                    minC = c;
                                    minR = r;
                                }
                            }
                        }
                    }
                }

                if (minR == -1 || minC == -1)
                    continue;
                que.add(new Loca(minR, minC, minD));
            }

            // 적 kill!!!
            while (!que.isEmpty()) {
                Loca loca = que.poll();
                if (copy[loca.r][loca.c] == 1) {
                    copy[loca.r][loca.c] = 0;
                    kill++;
                }
            }
            turn--;
        }
        res = kill > res ? kill : res;
    }
}