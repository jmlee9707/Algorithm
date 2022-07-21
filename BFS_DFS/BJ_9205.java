package BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_9205 {
    // 맥주 마시면서 걸어가기
    static int T, n;

    static public class LOCATION {
        int x;
        int y;

        LOCATION(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine()); // 편의점 갯수

            LOCATION[] location = new LOCATION[n + 2];
            int[] check = new int[n + 2];
            Queue<LOCATION> q = new LinkedList<LOCATION>();

            boolean success = false;
            String[] str;

            for (int i = 0; i < n + 2; i++) {
                str = br.readLine().split(" ");
                location[i] = new LOCATION(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
            }

            LOCATION start = location[0]; // 시작 위치
            LOCATION end = location[n + 1]; // 도착 위치
            q.add(start); // 시작 위치로 부터 출발

            while (!q.isEmpty()) {
                LOCATION current = q.poll();
                // 만약 다음에 접근할 위치가 도착 위치?
                if (current.equals(end)) {
                    success = true;
                    break;
                }
                // 모든 방문할 위치 중에서 거리가 1000(맥주 20병) 안에 도착 할때만 Queue에 저장
                for (int i = 1; i < n + 2; i++) {
                    if (check[i] == 0
                            && Math.abs(current.x - location[i].x) + Math.abs(current.y - location[i].y) <= 1000) {
                        q.add(location[i]);
                        check[i] = 1; // 왔던 위치 다시 방문 하지 않기 위해서 만들어줌
                    }
                }
            }
            if (success) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }

        }
    }
}
