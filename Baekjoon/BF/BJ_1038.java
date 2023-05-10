package BF;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ_1038 {
    /*
     * 백준 1038
     * 감소하는 수
     */
    static int N, res, max, size;
    static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        if (N < 10) {
            System.out.println(N);
            System.exit(0);
        }
        max = 0;

        // 1자리는 10개 : 0~9 10개 10C1
        // 2자리는 1+2+3+4+5+6+7+8+9 10C2
        // 3자리는 10C3
        // 10자리는 1 10C10

        for (int i = 1; i <= 10; i++) {
            combi(i, 9, 0, "");
            if (N < list.size()) {
                Collections.sort(list);
                System.out.println(list.get(N));
                System.exit(0);
            }
        }

        System.out.println("-1");

    }

    public static void combi(int peek, int start, int cnt, String s) {
        if (peek == cnt) {
            list.add(Long.parseLong(s));
            return;
        }
        for (int i = start; i >= 0; i--) {
            combi(peek, i - 1, cnt + 1, s + i);
        }
    }
}
