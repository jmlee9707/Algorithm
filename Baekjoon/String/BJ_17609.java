package String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_17609 {
    /*
     * 백준 17609
     * 회문
     */
    static int N;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int res = twoPointer(s, 0);
            bw.append(res + "\n");
        }

        bw.flush();
    }

    public static int twoPointer(String s, int chance) throws IOException {

        int start = 0;
        int end = s.length() - 1;

        char[] text = s.toCharArray();

        for (int i = 0; i < s.length() / 2; i++) {
            if (text[start + i] == text[end - i])
                continue;
            else if (chance == 0
                    && (text[start + 1 + i] == text[end - i] || (text[start + i] == text[end - 1 - i]))) {
                int st = twoPointer(s.substring(start + 1 + i, end - i + 1), chance + 1);
                int et = twoPointer(s.substring(start + i, end - i), chance + 1);

                if (st == 0 || et == 0)
                    return 1;
                else
                    return 2;
            } else
                return 2;

        }

        return 0;
    }

}
