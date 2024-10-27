package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1446 {
    /*
     * !SECTION
     * 백준 1446
     * 지름길
     */
    static int N, D;
    static ArrayList<ArrayList<Node>> list;
    static int[] dist = new int[10001];

    static public class Node {
        int n, cost;

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        for (int i = 0; i < 10001; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < 10001; i++) {
            dist[i] = i;
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, c));
        }

        dijkstra(0);
        System.out.println(dist[D]);

    }

    public static void dijkstra(int start) {
        if (start > D)
            return;

        if (dist[start + 1] > dist[start] + 1) {
            dist[start + 1] = dist[start] + 1;
        }
        for (int i = 0; i < list.get(start).size(); i++) {
            Node node = list.get(start).get(i);
            int sum = dist[start] + node.cost;
            if (sum < dist[node.n])
                dist[node.n] = sum;
        }

        dijkstra(start + 1);

    }
}
