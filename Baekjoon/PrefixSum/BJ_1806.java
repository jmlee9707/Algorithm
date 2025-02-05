
package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1806 {
    static int N, S;
    static int[] prefix, num;
    static int start, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        start = 0;
        res = Integer.MAX_VALUE;

        prefix = new int[N + 1];
        num = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i - 1] + num[i];
            if (prefix[i] >= S && start == 0) {
                // 누적합이 S 이상이면
                start = i;
                res = i;
            }
        }

        if (start == 0) {
            System.out.println(0);
            return;
        }

        // start 부터 확인
        for (int i = start; i <= N; i++) {
            inner: for (int j = i - res; j <= i; j++) {
                int temp = prefix[i] - prefix[j] + num[j];
                if (temp >= S) {
                    int size = i - j + 1;
                    res = Math.min(size, res);
                } else
                    break inner;
            }
        }
        System.out.println(res);

    }

}
