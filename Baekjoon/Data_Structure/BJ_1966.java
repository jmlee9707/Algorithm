package Data_Structure;

import java.io.*;
import java.util.*;

public class BJ_1966 {
    // 프린터 큐
    static int T, N, M, res;
    static int[] priority; // 중요도 1~9

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        StringTokenizer st;

        // 테스트 케이스 시작
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            res = 0; // M번째 문서가 몇번째로 출력되는가? // 1부터 시작
            String[] temp = br.readLine().split(" ");

            Queue<int[]> que = new LinkedList<>(); // 큐 생성
            priority = new int[10];

            // 중요도 1-9사이 정수
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(temp[i]);
                priority[num]++; // 중요도 체크

                que.add(new int[] { i, num }); // 초기 순서, 중요도
            }

            while (!que.isEmpty()) {
                int[] doc = que.poll();
                boolean check = false;
                // 중요도 높은 문서가 있는가?
                for (int c = doc[1] + 1; c <= 9; c++) {
                    if (priority[c] >= 1) {
                        check = true;
                        break;
                    }
                }

                if (check) {
                    que.add(doc); // 뒤에 재배치
                } else {
                    priority[doc[1]]--;
                    res++; // 인쇄

                    if (M == doc[0]) {
                        break;
                    }
                }
            }
            System.out.println(res);
        }

    }
}
