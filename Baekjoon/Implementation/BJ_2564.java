package Implementation;

import java.util.Scanner;

public class BJ_2564 {
    // im 대비
    // 백준 경비원

    static int W, H, N; // 가로, 세로, 상점 개수
    static int sum, min, dist; // 합계, 최소, 거리
    static int dir, dong; // 동근이의 방향과 위치

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        W = sc.nextInt();
        H = sc.nextInt();
        N = sc.nextInt();

        int[][] location = new int[N][2];
        for (int i = 0; i < N; i++) {
            location[i][0] = sc.nextInt(); // 방향 입력
            location[i][1] = sc.nextInt(); // 위치 입력
        }

        // 1 : 북쪽, 2: 남, 3: 서, 4: 동

        // 동근이의 위치 받기
        dir = sc.nextInt(); // 동근 방향
        dong = sc.nextInt(); // 동근 위치

        sum = 0;
        for (int i = 0; i < N; i++) {
            // 최단 거리 구하기
            int num1 = location[i][0];
            int num2 = location[i][1];
            sum += function(num1, num2);
            System.out.println(function(num1, num2));
        }

        System.out.println(sum);
    }

    public static int function(int d, int n) {
        min = 0;
        if (dir == d) { // 같은 방향에 위치한 경우
            min = Math.abs(n - dong);
        } else if ((dir == 1 && d == 2) || (dir == 2 && d == 1) || (dir == 4 && d == 3) || (dir == 3 && d == 4)) {
            // 반대편에 위치한 경우, 시계방향, 반시계방향 살펴보기
            int case1 = 0;
            int case2 = 0;

            // 시계방향부터
            if (dir == 1 || dir == 2) {
                // 시계방향
                case1 = H + (W - dong) + (W - n);
                // 반시계방향
                case2 = H + dong + n;
                min = Math.min(case1, case2);
            } else if (dir == 3 || dir == 4) {
                // 시계방향
                case1 = W + (H - dong) + (H - n);
                // 반시계방향
                case2 = W + dong + n;
                min = Math.min(case1, case2);
            }

        } else {
            if (dir == 1) {
                if (d == 3) {
                    min = dong + n;
                } else if (d == 4) {
                    min = (W - dong) + n;
                }
            } else if (dir == 2) {
                if (d == 3) {
                    min = dong + (H - n);
                } else if (d == 4) {
                    min = (W - dong) + (H - n);
                }
            } else if (dir == 3) {
                if (d == 1) {
                    min = n + dong;
                }
                if (d == 2) {
                    min = n + (H - dong);
                }
            } else if (dir == 4) {
                if (d == 1) {
                    min = dong + (W - n);
                }
                if (d == 2) {
                    min = (H - dong) + (W - n);
                }
            }
        }

        return min;
    }
}
