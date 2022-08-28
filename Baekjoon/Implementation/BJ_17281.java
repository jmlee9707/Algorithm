package Baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17281 {
    /**
     * ⚾
     * 야구 룰과 동일
     * 두 팀은 경기가 시작하기 전까지 타순을 정해야하고 경기 중에는 타순을 변경할 수 없음
     * 9번 타자 이후엔 다시 1번 타자
     * 타자가 공을 쳐서 얻을 수 있는 결과는 안타, 2루타, 3루타, 홈런, 아웃중 하나이다.
     * 1번 선수가 4번타자
     * 
     * 가장 많이 득점을 하는 타순을 찾고 그때의 득점을 구하자
     * 그렇다면 순열 문제? -> 단순 구현 문제!
     * 시건 재헌은 1초
     */

    static int N, max;
    static int player[][]; // 선수가 얻는 결과
    static boolean[] ground, select;
    static int[] order;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;

        player = new int[N + 1][10]; // 1번 이닝부터, 1번 타자부터
        select = new boolean[10]; // 순열을 위해서

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                player[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        order = new int[10]; // 순서 정하기
        order[4] = 1; // 첫번쨰 순서는 4번타자
        select[4] = true; // 4번 타자는 이미 선택

        permutation(2); // 2번 순서부터 정하기

        System.out.println(max);

    }

    public static void permutation(int num) {
        if (num == 10) {
            // for (int i = 1; i <= 9; i++) {
            // System.out.print(order[i] + " ");
            // }
            // System.out.println();
            play();
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (select[i]) {
                continue;
            }
            select[i] = true;
            order[i] = num;
            permutation(num + 1);
            select[i] = false;
        }
    }

    public static void play() {

        int score = 0;
        int start = 1; // 시작 타자 1번부터

        for (int i = 1; i <= N; i++) {
            int out = 0;
            ground = new boolean[4]; // 1루, 2루, 3루, 홈 : 매 경기 때마다 초기화

            stop: while (true) {
                for (int j = start; j <= 9; j++) {
                    int playerNum = order[j];
                    int hit = player[i][playerNum];

                    switch (hit) {
                        case 0: // out
                            out++;
                            break;
                        case 1:
                            for (int k = 3; k >= 1; k--) {
                                if (ground[k] == true) {
                                    if (k == 3) {
                                        score++;
                                        ground[k] = false;
                                        continue;
                                    }
                                    ground[k] = false;
                                    ground[k + 1] = true;

                                }
                            }
                            ground[1] = true;
                            break;
                        case 2: // 2루타
                            for (int k = 3; k >= 1; k--) {
                                if (ground[k] == true) {
                                    if (k >= 2) {
                                        score++;
                                        ground[k] = false;
                                        continue;
                                    }
                                    ground[k] = false;
                                    ground[k + 2] = true; // 1루에 있던 선수는 3루로 이동해야함

                                }
                            }
                            ground[2] = true;
                            break;
                        case 3: // 3루타
                            for (int k = 3; k >= 1; k--) {
                                if (ground[k] == true) {
                                    score++;
                                    ground[k] = false;
                                }
                            }
                            ground[3] = true;
                            break;
                        case 4: // 홈런!
                            for (int k = 3; k >= 1; k--) {
                                if (ground[k] == true) {
                                    score++;
                                    ground[k] = false;
                                }
                            }
                            score++;
                            break;
                    }

                    if (out == 3) {
                        start = j + 1; // 3번쨰 아웃당한 다음타자부터 다음이닝 시작
                        if (start == 10) {
                            start = 1;
                        }
                        break stop;
                    }

                }
                start = 1;
            }
        }
        // System.out.println(score);
        max = max > score ? max : score;
    }

}
