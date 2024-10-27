package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1504 {
    /*
     * !SECTION
     * 백준 1504
     * 특정한 최단경로
     */
    static public class Node {
        int n, cost;

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }

    }

    static int N, E, v1, v2;
    static int[] dist = new int[801];
    static int max = 200000 * 100;
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        // 1->v1 -> v2 -> N
        int res1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        // System.out.println(res1);
        // 1 -> v2 -> v1 -> N
        int res2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
        // System.out.println(res2);
        System.out.println(res1 < max && res2 < max ? Math.min(res1, res2) : -1);
    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(dist, max);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int num = now.n;
            int cnt = now.cost;

            if (num == end)
                return dist[num];

            if (dist[num] < cnt)
                continue;
            for (int i = 0; i < list.get(num).size(); i++) {
                Node nex = list.get(num).get(i);

                int sum = dist[num] + nex.cost;
                if (sum < dist[nex.n]) {
                    dist[nex.n] = sum;
                    pq.add(new Node(nex.n, sum));
                }
            }
        }
        return max;
    }
}
