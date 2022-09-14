package Programmers;

public class Solution_92342 {
    // 양궁 대회
    // 프로그래머스 카카오 2022 블라인드 문제
    static int n = 9;
    static int[] info = { 0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1 }; // 어피치의 화살
    static int[] ryan, appeach, res;
    static int maxD = 0;

    public static void main(String[] args) {
        int[] answer = {};
        appeach = info.clone(); // 배열 복사

        res = new int[11];

        ryan = new int[11];// ryan의 점수
        dart(0, n);
        // 라이언은 어피치보다 많이 맞추거나
        // 어피치가 쏘지 않은 곳에 1발씩 쏴야 한다.

        // 라이언은 어피치보다 많이 맞추거나
        // 어피치가 쏘지 않은 곳에 1발씩 쏴야 한다.
        if (maxD == 0) {
            answer = new int[1];
            answer[0] = -1;
        } else {
            answer = new int[11];
            answer = res.clone();
        }

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static void dart(int cnt, int n) {

        if (cnt == n) {
            // 다트 다 쐈으면
            // 차이 구하기
            int appeachSum = 0, ryanSum = 0;
            for (int i = 0; i < 11; i++) {
                if (appeach[i] == 0 && ryan[i] == 0)
                    continue;
                if (appeach[i] != 0) {
                    if (appeach[i] >= ryan[i]) {
                        appeachSum += 10 - i;
                        continue;
                    }
                }
                if (ryan[i] != 0) {
                    if (ryan[i] > appeach[i])
                        ryanSum += 10 - i;
                }
            }

            // 최댓값 저장!
            // if (ryanSum > appeachSum) {
            if (maxD <= (ryanSum - appeachSum)) {
                maxD = ryanSum - appeachSum;
                res = new int[11];
                res = ryan.clone(); // 배열 복사
            }
            // }
            return;
        }

        // 중복 순열
        for (int i = 0; i < 11; i++) {
            if (ryan[i] > appeach[i])
                return;
            ryan[i]++;
            dart(cnt + 1, n);
            ryan[i]--;
        }

    }

}
