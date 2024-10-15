package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_20920 {
    /*
     * 백준 20920
     * 영단어 암기는 괴로워
     */

    static public class Words {
        int cnt;
        int leng;
        String word;

        public Words(int cnt, int leng, String word) {
            this.cnt = cnt;
            this.leng = leng;
            this.word = word;
        }
    }

    static ArrayList<Words> list;
    static HashMap<String, Words> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (s.length() >= M) {
                if (map.containsKey(s)) {
                    map.put(s, new Words(map.get(s).cnt + 1, s.length(), s));
                } else
                    map.put(s, new Words(1, s.length(), s));
            }
        }

        // hashMap을 기준으로 정렬
        list = new ArrayList<>(map.values());
        Collections.sort(list, new Comparator<Words>() {
            @Override
            public int compare(Words w1, Words w2) {
                if (w1.cnt != w2.cnt)
                    return w2.cnt - w1.cnt;
                else if (w1.leng != w2.leng)
                    return w2.leng - w1.leng;
                else
                    return w1.word.compareTo(w2.word);
            }
        });

        for (Words w : list) {
            sb.append(w.word + "\n");
        }
        System.out.println(sb);
    }
}