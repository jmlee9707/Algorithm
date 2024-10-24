package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_5972 {
    /*
     * 백준 5972
     * 택배 배송
     * ->다익스트라
     */
    static int N, M;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] dist = new int[50001];

    static class Node {
        int idx, cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            graph.get(r).add(new Node(c, num));
            graph.get(c).add(new Node(r, num));
        }

        dijkstra(1); // 다익스트라

        System.out.println(dist[N]);

    }

    static public void dijkstra(int start) {

        Arrays.fill(dist, Integer.MAX_VALUE); // 최대치로 채우기

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost); // 우선순위 큐
        pq.add(new Node(start, 0));
        dist[start] = 0; // 시작치에서 가중치는 0

        while (!pq.isEmpty()) {
            Node n = pq.poll();
            int num = n.idx;
            int dis = n.cost;

            if (dist[num] < dis)
                continue; // 처리된 적 있음
            for (int i = 0; i < graph.get(num).size(); i++) {
                Node nextN = graph.get(num).get(i);
                int sum = dist[num] + nextN.cost;

                if (sum < dist[nextN.idx]) {
                    dist[nextN.idx] = sum;
                    pq.add(new Node(nextN.idx, sum));
                }
            }

        }
    }
}
