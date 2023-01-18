package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_18111 {
    /*
     * 백준 18111
     * 마인크래프트
     */
    static int N, M, B, resH, height, max, min, block;
    static int[][] ground; // 땅
    static int sec = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        B = Integer.parseInt(st.nextToken()); // 블록 개수, 인벤토리

        ground = new int[N][M];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE; // 최대 높이 256이기 때문에
        resH = -1; // 출력 할 최대 높이

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {

                ground[i][j] = Integer.parseInt(st.nextToken(" "));
                max = ground[i][j] > max ? ground[i][j] : max; // 최대 땅 높이 구하기
                min = ground[i][j] < min ? ground[i][j] : min;
            }
        }

        if (min == max) {
            System.out.println("0 " + max);
            System.exit(0);
        }

        // 최소층부터 최대층까지
        outer: for (int f = min; f <= max; f++) {
            int cnt = 0; // 초 카운팅
            block = B;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (ground[r][c] > f) {
                        cnt += 2 * Math.abs(ground[r][c] - f); // 블록 제거
                        block += Math.abs(ground[r][c] - f); // 블록 인벤토리에 하나 추가
                    } else if (ground[r][c] < f) {
                        cnt += Math.abs(f - ground[r][c]); // 블록 위에 놓기
                        block -= Math.abs(f - ground[r][c]);
                    }

                }
            }
            if (block >= 0) {
                if (sec >= cnt) {
                    sec = cnt;
                    resH = f;
                }
            }

        }

        System.out.println(sec + " " + resH);

    }
}
