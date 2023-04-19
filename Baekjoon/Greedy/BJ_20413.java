package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20413 {
    /*
     * 백준 20413
     * 다이아몬드 (Easy)
     */
    static public int N, b, s, g, p, d, res;
    static public char[] grade;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        b = Integer.parseInt(st.nextToken()) - 1;
        s = Integer.parseInt(st.nextToken()) - 1;
        g = Integer.parseInt(st.nextToken()) - 1;
        p = Integer.parseInt(st.nextToken()) - 1;
        d = p + 1;
        res = 0;
        grade = br.readLine().toCharArray();

        // 첫달
        if (grade[0] == 'B')
            res += b;
        else if (grade[0] == 'S')
            res += s;
        else if (grade[0] == 'G')
            res += g;
        else if (grade[0] == 'P')
            res += p;
        else if (grade[0] == 'D')
            res += d;

        int beforeMonth = res; // 이전달 돈

        for (int i = 1; i < N; i++) {
            int maxMoney = calc(grade[i]);
            if (grade[i] != 'D') {
                res = res + (maxMoney - beforeMonth);
                beforeMonth = maxMoney - beforeMonth;

            } else {
                res += d;
            }
        }

        System.out.println(res);
    }

    public static int calc(char gr) {
        if (gr == 'B')
            return b;
        else if (gr == 'S')
            return s;
        else if (gr == 'G')
            return g;
        else if (gr == 'P')
            return p;
        else
            return (p + 1);
    }
}
