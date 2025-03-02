package Softeer.lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ST_427716 {
    /*
     * softeer
     * GPT식 숫자비교
     */
    public static class Num implements Comparable<Num> {
        int x, y;
        String full;

        public Num(int x, int y, String full) {
            this.x = x;
            this.y = y;
            this.full = full;
        }

        @Override
        public int compareTo(Num n) {
            if (this.x == n.x) {
                return this.y - n.y;
            } else
                return this.x - n.x;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Num[] arr = new Num[N];

        for (int i = 0; i < N; i++) {
            String f = br.readLine();
            String[] s = f.split("\\.");
            if (s.length == 1) {
                arr[i] = new Num(Integer.parseInt(f), -1, f);
            } else {
                arr[i] = new Num(Integer.parseInt(s[0]), Integer.parseInt(s[1]), f);
            }

        }
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            System.out.println(arr[i].full);
        }
    }
}
