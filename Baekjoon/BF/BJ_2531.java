package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_2531 {
    /*
     * 백준 2531
     * 회전초밥
     */
    static int N, D, K, C;
    static boolean hasEventSushi = false;
    static int max = Integer.MIN_VALUE;
    static HashMap<Integer, Integer> sushi;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 접시 수
        D = Integer.parseInt(st.nextToken()); // 초밥 가지 수
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        sushi = new HashMap<>();
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }

        for (int i = 0; i < K; i++) {

            int num = list.get(i);
            sushi.put(num, sushi.getOrDefault(num, 0) + 1);
            if (num == C)
                hasEventSushi = true;
        }

        max = hasEventSushi ? sushi.size() : sushi.size() + 1;

        int start = 0;
        int end = K - 1;

        int cnt = 0;
        while (cnt < N) {
            // 제거
            int ss = list.get(start);

            if (sushi.get(ss) > 1)
                sushi.put(ss, sushi.get(ss) - 1);
            else
                sushi.remove(ss);

            // 추가
            start = (start + 1) % N;
            end = (end + 1) % N;

            int se = list.get(end);
            if (sushi.containsKey(se)) {
                sushi.put(se, sushi.get(se) + 1);
            } else {
                sushi.put(se, 1);
            }

            hasEventSushi = sushi.containsKey(C);
            max = Math.max(hasEventSushi ? sushi.size() : sushi.size() + 1, max);
            cnt++;
        }

        System.out.println(max);
    }
}
