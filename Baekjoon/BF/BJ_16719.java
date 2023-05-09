package BF;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_16719 {
    static boolean visited[];
    static int N;
    static char alpha[];
    static BufferedWriter bw;

    // ZOAC
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = s.length();
        visited = new boolean[N];
        alpha = s.toCharArray(); // 배열로 변경
        // StringBuilder sb = new StringBuilder();
        // 분할 정복
        zoac(0, N - 1);
        bw.flush();

    }

    public static void zoac(int left, int right) throws IOException {
        if (left > right)
            return; // 끝!
        int start = left;

        // 사이에 있는 가장 작은 수
        for (int i = left; i <= right; i++) {
            if (alpha[start] > alpha[i]) {
                start = i;
            }
        }
        visited[start] = true; //

        for (int i = 0; i < N; i++) {
            if (visited[i] == true) {
                bw.write(alpha[i]);
            }
        }
        bw.newLine();
        zoac(start + 1, right);
        zoac(left, start - 1);
    }
}
