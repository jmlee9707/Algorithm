package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Cctv {
    int x;
    int y;
    int type; // cctv 번호

    public Cctv(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}

public class BJ_15683 {
    /*
     * 백준 15683
     * 감시
     */
    static int N, M, K, min, cctvNum;
    static int[][] office, copyOffice;
    static int[] dr = { -1, 0, 1, 0 }; // 상우하좌
    static int[] dc = { 0, 1, 0, -1 };
    static ArrayList<Cctv> list;
    static int[] dir; // cctv 방향 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        office = new int[N][M];
        min = Integer.MAX_VALUE; // 감시 가능한 영역
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    list.add(new Cctv(i, j, office[i][j])); // cctv 리스트에 보관
                }
            }
        }

        dir = new int[list.size()];
        cctvNum = list.size();

        // cctv 종류별 감시 위치 개수
        // 1-> 4개, 2-> 2개, 3->4개, 4->4개, 5-> 1개

        combi(0); // 카메라 방향 지정
        System.out.println(min);

    }

    public static void combi(int num) {
        // cctv 번호 확인
        if (num == cctvNum) {
            copyOffice = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    copyOffice[i][j] = office[i][j];
                }
            }

            // 사각지대 개수 확인
            for (int i = 0; i < cctvNum; i++) {
                int d = dir[i];
                Cctv cctv = list.get(i);
                checkCctv(d, cctv);
            }
            countArea(); // 사각지대 체크
        } else {
            for (int i = 0; i < 4; i++) {
                dir[num] = i;
                combi(num + 1);
            }
        }

    }

    public static void checkCctv(int d, Cctv cctv) {
        // cctv 번호와 방향으로 map 등록
        if (cctv.type == 1) {
            observeDir(d, cctv);
        } else if (cctv.type == 2) {
            observeDir(d, cctv);
            observeDir((d + 2) % 4, cctv);
        } else if (cctv.type == 3) {
            // 직각으로 확인 가능
            observeDir(d, cctv);
            observeDir((d + 1) % 4, cctv);
        } else if (cctv.type == 4) {
            // 3방향 확인 가능
            if (d == 0) {
                observeDir(0, cctv);
                observeDir(1, cctv);
                observeDir(3, cctv);
            } else if (d == 1) {
                observeDir(0, cctv);
                observeDir(1, cctv);
                observeDir(2, cctv);
            } else if (d == 2) {
                observeDir(1, cctv);
                observeDir(2, cctv);
                observeDir(3, cctv);
            } else if (d == 3) {
                observeDir(0, cctv);
                observeDir(2, cctv);
                observeDir(3, cctv);
            }

        } else if (cctv.type == 5) { // 상하좌우 모두 확인
            observeDir(0, cctv);
            observeDir(1, cctv);
            observeDir(2, cctv);
            observeDir(3, cctv);
        }
    }

    public static void observeDir(int d, Cctv cctv) {
        // 0 : 상, 1 : 우, 2 : 하, 3 : 좌
        int nr = cctv.x + dr[d];
        int nc = cctv.y + dc[d];

        while (nr >= 0 && nc >= 0 && nr < N && nc < M && copyOffice[nr][nc] != 6) {
            copyOffice[nr][nc] = -1;
            nr += dr[d];
            nc += dc[d];
        }
    }

    public static void countArea() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyOffice[i][j] == 0)
                    cnt++;
            }
        }
        min = Math.min(cnt, min);
    }
}
