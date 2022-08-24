package Baekjoon.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BJ_1260
 * DFS와 BFS
 * 그래프를 DFS와 BFS로 탐색한 결과를 출력
 */
public class BJ_1260 {
    static int N, M, V; // 정점의 개수, 간선의 개수, 탐색을 시작한 정점의 번호
    static int[][] graph; // 간선의 연결을 나타내기 위해서
    static boolean[] check; // 방문 여부 확인

    public static void main(String[] args) throws IOException {

        // 방문할 수 있는 정점이 여러개인 경우 정점 번호가 작은 것을 먼저 방문
        // 정점의 번호는 1부터 N까지

        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        V = Integer.parseInt(st.nextToken()); // 탐색을 시작한 정점의 번호

        graph = new int[N + 1][N + 1]; //
        check = new boolean[N + 1]; // 방문 여부 확인

        // 정점 연결 - 간선 상태 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x][y] = graph[y][x] = 1; // 연결되어 있으면 1로 저장
        }

        // dfs를 수행한 결과
        dfs(V);

        System.out.println(); // 줄바꿈
        check = new boolean[N + 1]; // 방문 상태 초기화
        // bfs를 수행한 결과
        bfs(V);

    }

    // V부터 방문한 점 순서대로 출력
    public static void dfs(int start) {
        check[start] = true; // 처음 시작 정점 체크
        System.out.print(start + " ");
        for (int i = 1; i <= N; i++) {
            if (graph[start][i] == 1 && check[i] == false) {
                check[i] = true;
                dfs(i); // 재귀 호출
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(start); // 시작 정점부터
        check[start] = true;

        while (!que.isEmpty()) {
            int temp = que.peek(); // 들어온 정점
            que.poll(); //
            System.out.print(temp + " ");
            // check[temp]
            // 작은 정점부터 방문
            for (int i = 1; i <= N; i++) {
                if (graph[temp][i] == 1 && check[i] == false) {
                    que.add(i);
                    check[i] = true; // 방문 확인
                }
            }
        }
    }

}