package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BJ_1411 {
    /*
     * 백준 1411
     * 비슷한 단어
     */
    static int N, res;
    static String alpha[];
    static int[] numbers;
    static HashMap<Character, Character> map;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        alpha = new String[N];
        numbers = new int[2]; // 조합 저장

        for (int i = 0; i < N; i++) {
            alpha[i] = br.readLine();
        }

        res = 0; // 몇개의 쌍?

        // 단어를 숌스럽게 바꾼다
        // 모든 알파벳을 다른 알파벳으로 교체
        // 알파벳은 중복해서 바꿀 수 없음
        // 자기 자신으로 바꾸는 것은 가능

        combi(0, 0); // 2개 뽑아서 비교

        System.out.println(res);
    }

    public static void combi(int start, int cnt) {
        if (cnt == 2) {
            // 같은 쌍인가?
            if (checkSimilar(alpha[numbers[0]], alpha[numbers[1]]))
                res++;
            return;
        }

        for (int i = start; i < N; i++) {
            numbers[cnt] = i;
            combi(i + 1, cnt + 1);
        }

    }

    public static boolean checkSimilar(String s1, String s2) {
        map = new HashMap<>();
        String temp = ""; // s1을 숌스럽게 만든 문자열

        for (int i = 0; i < s1.length(); i++) {
            char origin = s1.charAt(i);
            char compare = s2.charAt(i);

            if (!map.containsKey(origin)) {
                if (map.containsValue(compare))
                    return false;
                map.put(origin, compare);
                temp += compare;
            } else {
                temp += map.get(origin);
            }
        }

        if (temp.equals(s2))
            return true;
        else
            return false;
    }
}
