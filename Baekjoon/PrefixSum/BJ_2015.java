package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_2015 {
    /*
     * 백준 2015
     * 수들의 합4
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        long[] sum = new long[N + 1];

        sum[0] = 0;

        st = new StringTokenizer(br.readLine(), " ");
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L); // 합 == K 일 경우

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = arr[i] + sum[i - 1];
        }

        long cnt = 0;
        long res = 0;

        for (int i = 1; i <= N; i++) {
            // sum[j] - sum[i-1] = K
            // sum[j] - K = sum[i-1]
            // 이전 누적합 중에 존재한다면 ++

            if (sum[i] == K)
                cnt++;
            cnt = map.containsKey(sum[i] - K) ? map.get(sum[i] - K) : 0;
            res += cnt;

            if (map.containsKey(sum[i]))
                map.put(sum[i], map.get(sum[i]) + 1);
            else
                map.put(sum[i], 1L);

        }

        System.out.println(res);

    }
}
