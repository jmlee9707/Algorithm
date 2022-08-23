package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14719 {
    static int H, W, res, rightM, leftM, nowH;
    static int world[];
    // 빗물

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        world = new int[W + 1]; // 빗물 정보 수집
        res = 0;
        rightM = leftM = nowH = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= W; i++) {
            // W 가로 길이
            world[i] = Integer.parseInt(st.nextToken()); // 높이
        }

        // 왼쪽에서 가장 높은 높이, 오른쪽에서 가장 높은 높이, 그중 작은 높이 구하기
        for (int i = 2; i < W; i++) {
            rightM = leftM = nowH = 0; // 초기화

            // 왼쪽 제일 높은 곳 구하기
            for (int j = 1; j < i; j++) {
                leftM = leftM > world[j] ? leftM : world[j];
            }
            for (int j = i + 1; j <= W; j++) {
                rightM = rightM > world[j] ? rightM : world[j];
            }

            if (world[i] < leftM && world[i] < rightM) {
                int water = Math.min(leftM, rightM);
                res = res + (water - world[i]);
            }
        }

        System.out.println(res);

    }
}
