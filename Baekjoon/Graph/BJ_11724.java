package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_11724 {
    // 백준 연결 요소의 개수
    static ArrayList<ArrayList<Integer>> graph;
    static int n, m, res;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 정점의 개수
        m = sc.nextInt(); // 간선의 개수

        // m개의 줄에 간선의 양 끝점 u와 v
        graph = new ArrayList<>();
        graph.add(new ArrayList<>()); // 1부터 시작할거라 dummy 값
        for (int i = 1; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= m; i++) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            graph.get(num1).add(num2); // 리스트 더하기
            graph.get(num2).add(num1);
        }

        // ====== 모두 연결되어 있는지 어떻게 확인하지?
        int res = 0; // 연결 요소 카운팅
        // 모든 정점에 대해 dfs를 해보자!
        visited = new boolean[n + 1]; // 방문 체크!

        for (int i = 1; i <= n; i++) {
            if (check(i)) {
                res++;
            }
        }

        System.out.println(res);

    }

    public static boolean check(int v) {
        if (visited[v])
            return false;
        else {
            visited[v] = true; // 방문체크!
            // 정점의 모든 연결되어 있는 다른 정점에 대해서 방문!
            int size = graph.get(v).size();
            for (int i = 0; i < size; i++) {
                int visit = graph.get(v).get(i);
                if (!visited[visit]) {
                    check(visit);
                }
            }
            return true;
        }
    }
}
