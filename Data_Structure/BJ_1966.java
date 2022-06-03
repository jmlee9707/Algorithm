package Data_Structure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1966 {
    // 프린터 큐
    static int T, N, M, res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        // 테스트 케이스 시작
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt(); // 문서의 개수
            M = sc.nextInt(); // 궁금한 문서
            res = 0; // M번째 문서가 몇번째로 출력되는가?

            Queue<int[]> que = new LinkedList<>(); // 큐 생성

            // 중요도 1-9사이 정수
            for (int i = 0; i < N; i++) {
                que.add(new int[] { i, sc.nextInt() }); // 초기 순서, 중요서
            }

            while (!que.isEmpty()) {
                int[] now = que.poll(); // 현재 문서
                int cnt = 0;
                int impol = now[1]; // 현재 문서의 중요도

            }

            for (int i = 0; i < N; i++) {

                // int impol = arr[i]; // 중요도
                // int cnt = 0; //
                for (int j = 0; j < N; j++) {
                    if (j == i)
                        continue; // 같은숫자는 패스

                    if (arr[j] > impol) {
                        // 나머지 문서 중에 현재보다 중요도가 큰 문서가 있다면
                        que.add(i); // 내가 현재 몇번째 문서인지를 저장
                        cnt++;
                        break;
                    }
                }
                if (cnt == 0) {
                    // 내가 제일 중요도가 큰 문서라면
                    printq.add(i); // 몇번째 문서인지 푸시
                }
            }

            while (!que.isEmpty()) {
                printq.add(que.poll()); // 하나의 큐로 이동시키기
            }

            for (int i = 1; i <= N; i++) {
                System.out.println(printq.peek());
                if (printq.peek() == M) { // 내가 궁금한 문서의 순서라면
                    res = i;
                    break; // 종료
                }
                printq.poll(); // 하나씩 값 꺼내서 날리기
            }

            System.out.println(res);

        }

    }
}
