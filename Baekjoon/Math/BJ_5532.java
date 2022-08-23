package Math;

import java.util.Scanner;

// 방학숙제

public class BJ_5532 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int korean = sc.nextInt(); // 풀어야할 국어 페이지
        int math = sc.nextInt(); // 풀어야할 수학 페이지

        int dailyKorean = sc.nextInt();
        int dailyMath = sc.nextInt();

        int k = 0;
        int m = 0;

        if (korean % dailyKorean == 0) {
            k = korean / dailyKorean;
        } else {
            k = korean / dailyKorean + 1;
        }

        if (math % dailyMath == 0) {
            m = math / dailyMath;
        } else {
            m = math / dailyMath + 1;
        }

        System.out.println(total - Math.max(k, m));

    }
}