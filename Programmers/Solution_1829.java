package Programmers;

import java.util.Stack;
// 프로그래머스
// 카카오프렌즈 컬러링북
// 1829
// 2017 카카오코드 예선

public class Solution_1829 {
    static boolean visited[][]; // 방문 배열
    static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
    static int[] dc = { 0, 0, -1, 1 };

    static public class Loca {
        int r;
        int c;

        public Loca(int r, int c) {
            this.r = r;
            this.c = c;
        }

    }

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = { { 1, 1, 1, 0 }, { 1, 1, 1, 0 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 },
                { 0, 0, 0, 1 } };

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];

        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && visited[i][j] == false) {
                    int res = 0;
                    // dfs
                    Stack<Loca> stack = new Stack<>();
                    stack.add(new Loca(i, j));
                    visited[i][j] = true; // 방문체크
                    int num = picture[i][j]; // 값

                    while (!stack.isEmpty()) {
                        Loca temp = stack.peek();

                        int cnt = 0;

                        for (int d = 0; d < 4; d++) {
                            // 방문체크 하기
                            int nr = temp.r + dr[d];
                            int nc = temp.c + dc[d];
                            if (nr < m && nc < n && nr >= 0 && nc >= 0 && !visited[nr][nc] && picture[nr][nc] == num) {
                                stack.add(new Loca(nr, nc));
                                visited[nr][nc] = true;
                                res++;
                                cnt++;
                            }
                        }
                        if (cnt == 0) {
                            stack.pop();
                        }

                    }

                    maxSizeOfOneArea = maxSizeOfOneArea > res ? maxSizeOfOneArea : res; // 최대값 저장
                    numberOfArea++;
                }
            }
        }

        maxSizeOfOneArea++;
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        System.out.println(answer[0] + " " + answer[1]);

    }
}
