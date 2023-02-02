package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_1325 {
    static int N, M, max, cnt;
    static boolean[] visited;
    static LinkedList<Integer> haking; // 해킹 가능한 컴퓨터
    static ArrayList<ArrayList<Integer>> com;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 트리 구조 선언
        for (int i = 0; i <= N; i++) {
            com.add(new ArrayList<>());
        }

        // 연결 관계 구현
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());

            com.get(temp1).add(temp2);
            com.get(temp2).add(temp1);
        }

        max = 0;
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            int size = com.get(i).size(); // 연결된 컴퓨터의 수
            if (size == 0)
                continue;
            else
                isLinked(i);
        }

    }

    public static void isLinked(int start) {
        // // 연결된 컴퓨터의 수만큼
        // for(int j=0; j<size; j++){
        // if(!visited[com.get(i).get(j)]){

        // }
        // }
    }
}
