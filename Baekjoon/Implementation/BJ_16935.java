package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16935 {
    /*
     * 백준 16935
     * 배열 돌리기3
     */
    static public int N, M, R;
    static public int[][] map;
    static public int[][] copy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < R; i++) {
            int type = Integer.parseInt(st.nextToken());
            turn(type, map.length, map[0].length);

        }
        printMap();

    }

    public static void turn(int t, int n, int m) {
        if (t == 1) { // 상하 반전
            copy = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    copy[i][j] = map[n - 1 - i][j];
                }
            }
            map = new int[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = copy[i].clone();
            }
        } else if (t == 2) { // 좌우 반전
            copy = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    copy[i][j] = map[i][m - 1 - j];
                }
            }
            map = new int[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = copy[i].clone();
            }
        } else if (t == 3) { // 오른쪽 90도
            copy = new int[m][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    copy[j][n - i - 1] = map[i][j];
                }
            }
            map = new int[m][n];
            for (int i = 0; i < m; i++) {
                map[i] = copy[i].clone();
            }

        } else if (t == 4) { // 왼쪽 90도
            copy = new int[m][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    copy[m - 1 - j][i] = map[i][j];
                }
            }
            map = new int[m][n];
            for (int i = 0; i < m; i++) {
                map[i] = copy[i].clone();
            }

        } else if (t == 5) { // 시계 회전
            copy = new int[n][m];
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < m / 2; j++) {
                    copy[i][j + (m / 2)] = map[i][j];
                }
                for (int j = m / 2; j < m; j++) {
                    copy[i + (n / 2)][j] = map[i][j];
                }
            }
            for (int i = n / 2; i < n; i++) {
                for (int j = 0; j < m / 2; j++) {
                    copy[i - (n / 2)][j] = map[i][j];
                }
                for (int j = m / 2; j < m; j++) {
                    copy[i][j - (m / 2)] = map[i][j];
                }
            }
            map = new int[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = copy[i].clone();
            }

        } else {
            copy = new int[n][m];
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < m / 2; j++) { // 1번 그룹
                    copy[i + (n / 2)][j] = map[i][j];
                }
                for (int j = m / 2; j < m; j++) { // 2번 그룹
                    copy[i][j - (m / 2)] = map[i][j];
                }
            }
            for (int i = n / 2; i < n; i++) {
                for (int j = 0; j < m / 2; j++) { // 4번 그룹
                    copy[i][j + (m / 2)] = map[i][j];
                }
                for (int j = m / 2; j < m; j++) { // 3번 그룹
                    copy[i - (n / 2)][j] = map[i][j];
                }
            }
            map = new int[n][m];
            for (int i = 0; i < n; i++) {
                map[i] = copy[i].clone();
            }
        }

    }

    public static void printMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
