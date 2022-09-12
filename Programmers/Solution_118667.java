package Programmers;

import java.util.*;

public class Solution_118667 {

    static int[] queue1;
    static int[] queue2;

    // 프로그래머스
    // 2022 KAKAO TECH INTERNSHIP 문제 ✨
    // 두 큐 합 같게 만들기
    public static void main(String[] args) {
        int answer = -2;

        long sum = 0;
        long sum1 = 0;
        long sum2 = 0;

        Queue<Integer> que1 = new ArrayDeque<>();
        Queue<Integer> que2 = new ArrayDeque<>();

        for (int i = 0; i < queue1.length; i++) {
            que1.add(queue1[i]);
            sum1 += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            que2.add(queue2[i]);
            sum2 += queue2[i];
        }

        System.out.println(sum1 + " " + sum2);
        sum = sum1 + sum2;

        // 합계가 홀수 일 경우
        if (sum % 2 == 1) {
            System.out.println(-1);
            System.exit(0);
        }
        int move1 = 0;
        int move2 = 0;
        int max = que1.size() * 2;

        while (true) {

            if (move1 > max && move2 > max) {
                answer = -1;
                break;
            }

            if (sum1 == sum2) {
                answer = move1 + move2;
                break;
            } else if (sum1 > sum2) {
                int temp = que1.poll();
                sum1 -= temp;
                sum2 += temp;
                que2.add(temp);
                move1++;
            } else {
                int temp = que2.poll();
                sum2 -= temp;
                sum1 += temp;
                que1.add(temp);
                move2++;
            }
        }

        System.out.println(answer);

    }
}
