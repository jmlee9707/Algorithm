package BFS_DFS;

import java.util.*;
import java.io.*;

public class BJ_12851 {
    /*
     * !SECTION
     * 백준 12851
     * 숨바꼭질 2
     */

    static int N, K, count;
    static int[] moving = { -1, 1, 2 };
    static int[] time;

    static class Move {
        int n, cnt;

        public Move(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        count = 0;

        if (N >= K) {
            System.out.println(N - K);
            System.out.println(1);
            return;
        }
        time = new int[100001];
        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        Arrays.fill(time, -1);
        time[N] = 0;

        while (!que.isEmpty()) {
            int now = que.poll();

            if (now == K) {
                if (time[now] == time[K]) {
                    count++;
                    continue;
                } else
                    return;
            }

            for (int i = 0; i < 3; i++) {
                int nex = i == 2 ? now * i : now + moving[i];
                if (nex < 0 || nex > 100000 || (time[nex] != -1 && time[nex] < time[now] + 1))
                    continue;

                time[nex] = time[now] + 1;
                que.add(nex);
            }

        }

        System.out.println(time[K]);
        System.out.println(count);

    }
}
