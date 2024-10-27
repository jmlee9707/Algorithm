package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1753 {
    /*
     * 백준 1753
     * 최단 경로
     * -> 다익스트라
     */
    static int V, E, K;
    static int[] dist = new int[20001];
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();

    /**
     * Node
     */
    static class Node {
        int n, cost;

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        K = Integer.parseInt(br.readLine());
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(u).add(new Node(v, w));
        }

        dijkstra(K);
        for (int i = 1; i <= V; i++) {
            System.out.println(dist[i] != Integer.MAX_VALUE ? dist[i] : "INF");
        }

    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int num = now.n;
            int cnt = now.cost;

            if (dist[num] < cnt)
                continue;
            for (int i = 0; i < list.get(num).size(); i++) {
                Node next = list.get(num).get(i);
                int sum = dist[num] + next.cost;
                if (sum < dist[next.n]) {
                    dist[next.n] = sum;
                    pq.add(new Node(next.n, sum));
                }
            }
        }
    }
}
