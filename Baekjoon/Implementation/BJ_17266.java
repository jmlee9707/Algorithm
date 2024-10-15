package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17266 {
    /*
     * 백준 17266
     * 어두운 굴다리
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] light = new int[M + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;

        if (M == 1) {
            int pos = Integer.parseInt(st.nextToken());
            cnt = Math.max(N - pos, pos);
            System.out.println(cnt);
            return;
        }

        for (int i = 1; i <= M; i++) {
            int pos = Integer.parseInt(st.nextToken());
            light[i] = pos;
            if (i == 1) {
                cnt = pos;
                continue;
            }
            if (i == M)
                cnt = Math.max(cnt, N - pos);

            int temp = (int) Math.ceil((double) (pos - light[i - 1]) / 2);
            cnt = Math.max(cnt, temp);

        }
        System.out.println(cnt);
    }
}
