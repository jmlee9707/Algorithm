package Programmers;

import java.util.*;

public class Solution_118666 {
    // 프로그래머스
    // 성격유형 검사하기
    public static void main(String[] args) {
        String[] survey = { "AN", "CF", "MJ", "RT", "NA" };
        int[] choices = { 5, 3, 2, 7, 5 };
        String answer = "";
        Solution sol = new Solution();
        answer = sol.solution(survey, choices);
        System.out.println(answer);

    }
}

class Solution {
    // 각 성격 유형 점수가 같으면, 두 성격 유형 중 사전 순으로 빠른 성격 유형
    public String solution(String[] survey, int[] choices) {
        // survey : 질문마다 판단하는 지표
        // choices : 검사자가 각 질문마다 선택한 선택지
        String answer = "";
        Character[][] mbti = { { 'R', 'T' }, { 'C', 'F' }, { 'J', 'M' }, { 'A', 'N' } };
        HashMap<Character, Integer> score = new HashMap<>();
        score.put('R', 0);
        score.put('T', 0);
        score.put('C', 0);
        score.put('F', 0);
        score.put('J', 0);
        score.put('M', 0);
        score.put('A', 0);
        score.put('N', 0);

        int size = survey.length;

        for (int i = 0; i < size; i++) {
            if (choices[i] >= 1 && choices[i] <= 3) {
                score.put(survey[i].charAt(0), score.get(survey[i].charAt(0)) + (4 - choices[i]));
            } else if (choices[i] >= 5 && choices[i] <= 7) {
                score.put(survey[i].charAt(1), score.get(survey[i].charAt(1)) + (choices[i] - 4));
            } else {
                continue;
            }
        }

        // 1~3 : 비동의 -> survey[i].charAt(0);
        // 4 : 모르겠음 -> 사전순
        // 5~7 : 동의 -> survey[i].charAt(1);

        // 결과값 가져오기
        for (int i = 0; i < 4; i++) {
            if (score.get(mbti[i][0]) > score.get(mbti[i][1])) {
                answer += mbti[i][0];
            } else if (score.get(mbti[i][0]) < score.get(mbti[i][1]))
                answer += mbti[i][1];
            else {
                // 사전순으로 작은 것
                if ((int) mbti[i][0] < (int) mbti[i][1])
                    answer += mbti[i][0];
                else
                    answer += mbti[i][1];
            }
        }

        return answer;
    }
}