package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_20529 {
    /*
     * 백준 20529
     * 가장 가까운 세 사람의 심리적 거리
     * 비둘기 집의 원리
     */
    static int T, N, min;
    static String[] mbti;
    static int[] selected;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            mbti = br.readLine().split(" "); // mbti 쪼개기

            int maxCnt = 0;

            if (N > 32) {
                System.out.println(0);
                continue;
            } else
                maxCnt = 3;

            min = Integer.MAX_VALUE; // 최솟값
            selected = new int[maxCnt];

            makeCombi(0, 0, maxCnt);
            System.out.println(min);
        }
    }

    public static void makeCombi(int start, int cnt, int maxCnt) {
        if (cnt == maxCnt) {
            if (maxCnt == 2)
                calcTwoMbti();
            else if (maxCnt == 3)
                calcThreeMbti();

            return;
        }

        for (int i = start; i < N; i++) {
            selected[cnt] = i;
            makeCombi(i + 1, cnt + 1, maxCnt);
        }
    }

    public static void calcTwoMbti() {
        String a = mbti[selected[0]];
        String b = mbti[selected[1]];

        int dist = 0;

        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i))
                dist++;
        }

        min = Math.min(dist, min);
        return;
    }

    public static void calcThreeMbti() {
        String a = mbti[selected[0]];
        String b = mbti[selected[1]];
        String c = mbti[selected[2]];

        int dist = 0;

        for (int i = 0; i < 4; i++) {
            if (a.charAt(i) != b.charAt(i))
                dist++;
            if (b.charAt(i) != c.charAt(i))
                dist++;
            if (a.charAt(i) != c.charAt(i))
                dist++;
        }

        min = Math.min(dist, min);
        return;

    }
}
