package Baekjoon.BFS_DFS;

public class BJ_14940 {
    /*
     * 백준 14940
     * 쉬운 최단거리
     */
    static int n, m;
    static int[][] res, map;
    static boolean[][] visited;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    static class Loca1 {
        int r;
        int c;

        public Loca1(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        res = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i], -1);
        }
        visited = new boolean[n][m];
        Queue<Loca1> que = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    res[i][j] = 0; // 갈수 없는 거리
                    visited[i][j] = true;
                    que.add(new Loca1(i, j));
                } else if (map[i][j] == 0)
                    res[i][j] = 0;
            }
        }

        // 입력 끝!
        while (!que.isEmpty()) {
            Loca1 pop = que.remove();

            for (int d = 0; d < 4; d++) {
                int nr = pop.r + dr[d];
                int nc = pop.c + dc[d];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && !visited[nr][nc] && map[nr][nc] != 0) {
                    res[nr][nc] = res[pop.r][pop.c] + 1;
                    visited[nr][nc] = true; // 방문체크
                    que.add(new Loca1(nr, nc));
                }
            }
        }

        // 출력 시작
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
    }
}
