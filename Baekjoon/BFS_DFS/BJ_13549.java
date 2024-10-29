package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13549 {
    /*
     * NOTE -
     * 백준 13549
     * 숨바꼭질 3
     */
    static int N, K, res;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N - K);
            return;
        }
        if (N * 2 == K) {
            System.out.println(0);
            return;
        }
        time = new int[100001];
        Arrays.fill(time, -1);

        Queue<Integer> que = new LinkedList<>();
        time[N] = 0;
        que.add(N);

        while (!que.isEmpty()) {
            int now = que.poll();

            if (now == K) {
                if (time[now] == time[K]) {
                    System.out.println(time[K]);
                    return;
                }
            }
            for (int i = -1; i < 2; i++) {
                int nex = i == 0 ? now * 2 : now + i;
                if (nex < 0 || nex > 100000 || (time[nex] != -1 && time[now] + 1 > time[nex])) {
                    continue;
                }
                time[nex] = i != 0 ? time[now] + 1 : time[now];
                que.add(nex);
            }

        }
        System.out.println(time[K]);

    }
}
