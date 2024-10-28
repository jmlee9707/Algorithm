package Graph;

import java.util.*;
import java.io.*;

public class BJ_1916 {
    /*
     * !SECTION
     * 백준 1916
     * 최소비용 구하기
     */
    static int N, M, sN, eN;
    static ArrayList<ArrayList<Node>> list;
    static long[] dist;

    static public class Node {
        int n;
        long cost;

        public Node(int n, long cost) {
            this.n = n;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a <= N && b <= N)
                list.get(a).add(new Node(b, c));

        }
        dist = new long[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        sN = Integer.parseInt(st.nextToken());
        eN = Integer.parseInt(st.nextToken());
        Arrays.fill(dist, 100000 * 1000 + 1);

        dijkstra(sN, eN);
        System.out.println(dist[eN]);
    }

    public static void dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (int) (o1.cost - o2.cost));
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int num = now.n;
            long cnt = now.cost;

            if (num == end)
                return;
            if (dist[num] < cnt)
                continue;

            for (int i = 0; i < list.get(num).size(); i++) {
                Node next = list.get(num).get(i);
                long sum = next.cost + dist[num];
                if (sum < dist[next.n]) {
                    dist[next.n] = sum;
                    pq.add(new Node(next.n, sum));
                }

            }

        }
        return;
    }

}
