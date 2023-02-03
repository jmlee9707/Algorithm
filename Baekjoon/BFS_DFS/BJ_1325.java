package BFS_DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1325 {

    /*
     * 백준 1325
     * 효율적인 해킹
     */

    static int N, M, cnt;
    static boolean[] visited;
    static int[] res; // 결과 값 담아서 출력
    static ArrayList<Integer>[] com;// 해킹 정보 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // A가 B를 신뢰하면 B를 해킹할 경우 A도 해킹이 가능
        // N개의 컴퓨터의 그래프를 그리기

        com = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            com[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            com[a].add(b); // a는 b를 신뢰
        }
        res = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1]; // 방문 배열 초기화
            // dfs(i); // 시간초과 이유좀..
            bfs(i);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            max = Math.max(res[i], max);
        }

        // 오름차순으로 출력
        for (int i = 1; i <= N; i++) {
            if (res[i] == max)
                bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }

    // 시간 초과
    public static void dfs(int idx) {
        visited[idx] = true;

        for (int num : com[idx]) {
            System.out.println(num);
            if (!visited[num]) {
                res[num]++;
                dfs(num);
            }
        }
    }

    public static void bfs(int idx) {
        visited[idx] = true;
        Queue<Integer> que = new LinkedList<>();
        que.add(idx);

        while (!que.isEmpty()) {
            int temp = que.poll();
            for (int i = 0; i < com[temp].size(); i++) {
                int num = com[temp].get(i);
                if (!visited[num]) {
                    visited[num] = true;
                    res[num]++;
                    que.add(num);
                }
            }
        }

    }
}
