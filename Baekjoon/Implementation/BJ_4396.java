package Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BJ_4396 {
    /*
     * 백준 4396
     * 지뢰 찾기
     */
    static int n; // 10 보다 작거나 같은 양의 정수 n
    static boolean isClick = false; // 지뢰를 눌렀는지 누르지 않았는지 파악하기 위함
    static char[][] map, click; // 지뢰밭, 클릭한 곳
    static int dr[] = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 상하좌우 좌상 우상 좌하 우하
    static int dc[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        click = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                click[i][j] = s.charAt(j);
                if (!isClick && click[i][j] == 'x' && map[i][j] == '*') {
                    // 지뢰를 클릭했다면 모든 지뢰를 출력해야하기 떄문에
                    isClick = true;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 팔방 탐색!
        for (int i = 0; i < n; i++) {
            String pr = ""; // 임시 문자열
            for (int j = 0; j < n; j++) {
                // 클릭 된 것과 아직 클릭되지 않은 것
                if (click[i][j] == 'x') { // 클릭!
                    if (map[i][j] == '*')
                        pr += "*";
                    else {
                        // 팔방 탐색
                        int cnt = 0;
                        for (int d = 0; d < 8; d++) {
                            int nr = i + dr[d];
                            int nc = j + dc[d];
                            if (nr >= 0 && nc >= 0 && nr < n && nc < n && map[nr][nc] == '*')
                                cnt++;
                        }
                        pr = pr + cnt;
                    }

                } else { // 아직 클릭되지 않음
                    if (isClick && map[i][j] == '*')
                        pr += "*";
                    else
                        pr += ".";
                }
            }

            bw.write(pr + "\n");
        }

        bw.flush();
        bw.close();

    }
}
