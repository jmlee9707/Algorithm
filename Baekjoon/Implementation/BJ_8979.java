package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_8979 {
    /*
     * 백준 8979
     * 올림픽
     */
    static int N, K;
    static ArrayList<Country> list;

    static class Country implements Comparable<Country> {
        int cn; // 고유 번호
        int gold;
        int silver;
        int bronze;

        public Country(int cn, int gold, int silver, int bronze) {
            this.cn = cn;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Country c) {
            if (gold != c.gold)
                return c.gold - gold;
            else {
                if (silver != c.silver)
                    return c.silver - silver;
                else
                    return c.bronze - bronze;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new Country(n, g, s, b));
        }

        Collections.sort(list);

        int rank = 0;
        int[] score = new int[3];
        int countinuous = 1;

        for (int i = 0; i < list.size(); i++) {
            Country temp = list.get(i);

            if ((score[0] == temp.gold) && (score[1] == temp.silver) && (score[2] == temp.bronze)) {
                countinuous++;
            } else {
                // 동점자가 없을 경우
                rank += countinuous;
                countinuous = 1;

                score[0] = temp.gold;
                score[1] = temp.silver;
                score[2] = temp.bronze;
            }

            if (temp.cn == K) {
                System.out.println(rank);
                break;
            }
        }

    }
}
