package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1205 {
    /*
     * 백준 1205
     * 등수 구하기
     */
    static int N, P, taesu;
    static List<Integer> keylist;
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        taesu = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println("1");
            return;
        }

        st = new StringTokenizer(br.readLine(), " ");
        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(st.nextToken());
            if (map.containsKey(score)) {
                map.put(score, map.get(score) + 1);
            } else {
                map.put(score, 1);
            }
        }
        map.put(taesu, map.getOrDefault(taesu, 0) + 1);

        keylist = new ArrayList<>(map.keySet());
        Collections.sort(keylist, Collections.reverseOrder());

        int rank = 1;
        int ppl = 0;
        boolean isCheck = false;

        for (int score : keylist) {
            int num = map.get(score);
            ppl += num;

            if (score == taesu) {
                isCheck = true;
                break;
            }

            rank += num;

        }
        if (!isCheck || ppl > P) {
            System.out.println(-1);
        } else {
            System.out.println(rank);
        }

    }
}
