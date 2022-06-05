package ExhaustiveSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2961 {
    // 도영이가 만든 맛있는 음식

    static int min, n, s, b;
    static boolean check[];
    static int[][] food;

    public static void main(String[] args) throws NumberFormatException, IOException {
        min = Integer.MAX_VALUE; // 차이 최소값!

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 재료의 개수
        // System.out.println(n);

        food = new int[n][2]; // class type 배열
        check = new boolean[n]; // 선택여부 확인 배열

        // 입력값 배열에 저장
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            food[i][0] = Integer.parseInt(temp[0]); // 신맛
            food[i][1] = Integer.parseInt(temp[1]); // 쓴맛

        }

        subset(0); // 1부터 시작!
        System.out.println(min); // 최소값 출력

    }

    public static void subset(int cnt) {
        if (cnt == n) {
            s = 1; // 음식의 총 신 맛
            b = 0; // 음식의 총 쓴 맛
            int use = 0;

            for (int i = 0; i < n; i++) {
                if (check[i]) {
                    s = s * food[i][0]; // 신맛 구하기!
                    b = b + food[i][1]; // 쓴맛 구하기!
                    use++;
                }
            }

            if (Math.abs(s - b) < min && use != 0) {
                min = Math.abs(s - b);
            }
            return;
        }

        // 재료 사용!
        check[cnt] = true;
        subset(cnt + 1);
        // 재료 사용X
        check[cnt] = false;
        subset(cnt + 1);

    }
}
