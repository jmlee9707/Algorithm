package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_19637 {
    /*
     * 백준 19637
     * IF문 좀 대신 써줘
     */

    static int N, M;
    static StringBuilder sb;
    static ArrayList<Att> list;

    static public class Att {
        String title;
        int power;

        public Att(String title, int power) {
            this.title = title;
            this.power = power;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            list.add(new Att(st.nextToken(), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < M; i++) {
            getTitle(Integer.parseInt(br.readLine()));
        }

        System.out.println(sb.toString());
    }

    public static void getTitle(int attack) {
        int start = 0;
        int end = N;
        int middle = 0;

        while (start <= end) {

            middle = (start + end) / 2;
            int num = list.get(middle).power;

            if (num < attack) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        String ans = list.get(start).title;
        sb.append(ans).append("\n");

    }
}
