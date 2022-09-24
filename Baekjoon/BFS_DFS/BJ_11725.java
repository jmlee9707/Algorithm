package Baekjoon.BFS_DFS;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BJ_11725 {
    // 트리의 부모 찾기
    // 백준 11725

    // 루트가 없는 트리가 주어지고 이 때 트리의 투트를 1이라고 정했을때
    // 각 노드릐 부모를 구하라
    static int N;
    static ArrayList<Integer>[] list;
    static Stack<Integer> stack;
    static boolean[] check;
    static int res[];

    public static void dfs(int v, int parent) {
        for (int x : list[v]) {
            if (x == parent)
                continue; // 부모 노드는 제외
            res[x] = v; // v는 x의 부모
            dfs(x, v);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // n의 값이 크기 때문에 인접행렬 이용시 런타임에러
        // 따라서 인접 리스트를 이용해서 해야함!

        list = new ArrayList[N + 1];

        check = new boolean[N + 1];
        res = new int[N + 1];
        // 초기화
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
            list[b].add(a);

        }

        check[1] = true;

        dfs(1, 0);

        // 결과 값 출력!
        for (int i = 2; i <= N; i++) {
            System.out.println(res[i]);
        }
    }
}
