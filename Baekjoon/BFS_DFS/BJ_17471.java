package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17471 {
    /*
     * 백준 17471
     * 게리맨더링
     */
    static int N, min;
    static ArrayList<ArrayList<Integer>> list;
    static int[] population;
    static boolean[] isVisited, combi;

    public static class Area {
        int idx;
        int ppl;

        public Area(int idx, int ppl) {
            this.idx = idx;
            this.ppl = ppl;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        population = new int[N + 1];
        isVisited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < num; j++) {
                list.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 1; i <= N / 2; i++) {
            combi = new boolean[N + 1];
            combination(0, i, 1);
        }
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

    }

    public static void combination(int number, int count, int start) {

        if (number == count) {
            int a = bfs(true, count);
            int b = bfs(false, N - count);

            if (a != -1 && b != -1) {
                // 모두 연결
                min = Math.min(min, Math.abs(a - b));
            }
            return;

        }
        for (int i = start; i <= N; i++) {
            combi[i] = true;
            combination(number + 1, count, i + 1);
            combi[i] = false;
        }
    }

    public static int bfs(boolean ans, int size) {

        Queue<Integer> que = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];

        int cnt = 0;
        int num = 0;

        for (int i = 1; i <= N; i++) {
            if (combi[i] == ans) {
                que.add(i);
                visit[i] = true;
                num += population[i];
                cnt++;
                break;
            }
        }

        while (!que.isEmpty()) {
            if (size == cnt)
                break;
            int target = que.poll();

            int listSize = list.get(target).size();
            for (int j = 0; j < listSize; j++) {
                int number = list.get(target).get(j);
                if (combi[number] == ans && !visit[number]) {
                    cnt++;
                    visit[number] = true;
                    num += population[number];
                    que.add(number);
                }
            }
        }

        return size == cnt ? num : -1;

    }

}
