package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17276 {
    // 배열 돌리기
    static int T, N, D, rotate;
    static int[][] map;
    // static boolean[][] visit;
    static int dr[] = { 0, 1, 0, -1 }; // 우하좌상
    static int dc[] = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            map = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (D < 0) {
                D = D + 360; // 시계방향으로 돌리기
            } else if (D == 360 || D == 0) {
                // 돌릴 필요 없음
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        System.out.print(map[i][j] + " ");
                    }
                    System.out.println();
                }
                continue;
            }

            rotate = D / 45; // 45도로 몇번 돌려야 하는가?
            int box = N / 2; // 돌려야하는 작은 박스는 몇개?
            for (int i = 1; i <= box; i++) {
                bingbing(i);
            }
            // 출력하기
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("==================");
        }

    }

    public static void bingbing(int num) {
        // num부터 N-num+1까지
        int start = num;
        int end = N - num + 1;
        // int mid = (start + end) / 2; // 중간 값

        // 한번에 옮겨갈 칸수

        int d = 0; // 방향
        int r = start; // 시작점
        int c = start; // 시작점
        int cnt = (end - start) / 2;
        int temp1 = map[r][c];

        for (int i = 0; i < rotate; i++) {

            while (true) {

                int nr = r + cnt * dr[d];
                int nc = c + cnt * dc[d];
                // 경계값 벗어나면 방향 전환
                if (nr > end || nc > end || nr < start || nc < start) {
                    d = (d + 1) % 4;
                    nr = r + cnt * dr[d];
                    nc = c + cnt * dc[d];
                }
                int temp2 = map[nr][nc]; // 옮겨질 값
                map[nr][nc] = temp1; // 시작점저장
                // visit[r][c] = true;
                r = nr;
                c = nc;

                if (r == start && c == start) {
                    map[r][c] = temp1;
                    break;
                }
                temp1 = temp2;
            }

        }

    }
}
