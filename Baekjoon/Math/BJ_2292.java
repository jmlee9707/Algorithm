package Math;

import java.util.Scanner;

public class BJ_2292 {
    public static void main(String[] args) {
        // 벌집
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 방1개:1, 방2개:2~7, 방3개:8~19, 방4개 : 20~37, 방5개 : 38~61
        // 방이 커질때마다 6, 12, 18, 24,... 6의 배수로 늘어남

        int sum = 1;
        int res = 0;
        while (true) {
            sum = sum + (6 * res);
            if (sum >= n) {
                break;
            } else {
                res++;
            }
        }

        System.out.println(res + 1);

    }
}
