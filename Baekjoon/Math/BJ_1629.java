package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1629 {
    /*
     * 백준 1629
     * 곱셈
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a, b, c;
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        long num = 1;

        while (b > 0) {
            if (b % 2 == 1) {
                num = (num * a) % c;
            }
            a = (a * a) % c;
            b = b / 2;
        }

        System.out.println(num);
    }
}
