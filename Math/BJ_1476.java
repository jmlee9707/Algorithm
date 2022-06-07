package Math;

import java.util.Scanner;

public class BJ_1476 {
    // 날짜계산
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int s = sc.nextInt();
        int m = sc.nextInt();

        if (e == 15) {
            e = 0;
        }
        if (s == 28) {
            s = 0;
        }
        if (m == 19) {
            m = 0;
        }

        int year = 1; // 연도수
        while (true) {
            if (year % 15 == e && year % 28 == s && year % 19 == m) {
                break;
            }
            year++;
        }

        System.out.println(year);
    }
}
