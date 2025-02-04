package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_12919 {
    /*
     * 백준 12919
     * A와 B 2
     * 
     * 13% : 시간초과 발생 -> 완탐 조합으로 풀면 안됨
     */
    static String S, T;
    static int[] combi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        // 1 선택시 : A 추가
        // 2 선택시 : B 추가 후 문자열 뒤집기

        play(S, T);
        System.out.println(0);

    }

    public static void play(String s, String t) {
        if (t.length() < s.length()) {
            return;
        }

        if (s.equals(t)) {
            System.out.println(1);
            System.exit(0);
        }

        if (t.charAt(0) == 'B') {
            String str = t.substring(1);
            play(s, new StringBuilder(str).reverse().toString());
        }
        if (t.charAt(t.length() - 1) == 'A') {
            play(s, t.substring(0, t.length() - 1));
        }
        return;

    }
}
