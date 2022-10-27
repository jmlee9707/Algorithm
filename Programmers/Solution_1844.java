package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_1844 {

    // 프로그래머스
    // 게임 맵 최단거리

    public static void main(String[] args) {
        int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 } };
        Solution1 sol = new Solution1();
        int res = sol.solution(maps);
        System.out.println(res);
    }
}

class Solution1 {
    public class Position {
        int r;
        int c;
        int cost;

        public Position(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }

    static boolean[][] visited;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public int solution(int[][] maps) {
        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        Queue<Position> que = new LinkedList<>();
        que.add(new Position(0, 0, 1));
        visited[0][0] = true;

        int n = maps.length;
        int m = maps[0].length;

        while (!que.isEmpty()) {
            Position pos = que.poll();
            if (pos.r == n - 1 && pos.c == m - 1) {
                answer = pos.cost;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = pos.r + dr[i];
                int nc = pos.c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    if (maps[nr][nc] == 1 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        que.add(new Position(nr, nc, pos.cost + 1));
                    }

                }
            }
        }

        if (answer == 0)
            return -1;
        else
            return answer;
    }

}
