package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17140 {
    /*
     * 백준 17140
     * 이차원 배열과 연산
     */
    static int R, C, K, sec;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        sec = 0;

        while (true) {
            if (sec > 100) {
                sec = -1;
                break;
            }

        }
    }
}
