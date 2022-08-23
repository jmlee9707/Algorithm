package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Solution_72410
 */
public class Solution_72410 {

    // 2021 카카오 블라인드
    // 신규 아이디 추천
    // 카카오 아이디 추천
    public static void main(String[] args) throws IOException {
        // 아이디의 길이는 3자 이상, 15자 이하
        // 아이디는 알파벳 소문자, 숫자, 뺴기, 밑줄, 마침표 문자만 사용 가능
        // 마침표는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용 불가
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String new_id = br.readLine();
        String answer = "";

        // 1단계
        // 모든 대문자를 대응되는 소문자로 치환
        // char[] id = new_id.toCharArray();
        // for (int i = 0; i < new_id.length(); i++) {
        // if (id[i] - 0 > 65 && id[i] - 0 <= 90) {
        // id[i] = (char) (id[i] + 32);
        // }
        // }
        char[] id = new_id.toLowerCase().toCharArray();
        // 2단계
        // !, @, #, * 문자 제거
        for (int i = 0; i < id.length; i++) {
            if (id[i] == '.' || id[i] == '-' || id[i] == '_' || (id[i] >= '0' && id[i] <= '9')
                    || (id[i] >= 'a' && id[i] <= 'z')) {
                answer += id[i]; // 결과값에 더하기
            }
        }
        id = answer.toCharArray();
        answer = ""; // 초기화
        // 3단계
        // .로 바꾸기
        int cnt = 0;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == '.' && cnt != 0) {
                continue;
            } else if (id[i] == '.' && cnt == 0) {
                cnt++;
            } else if (id[i] != '.') {
                cnt = 0;
            }
            answer = answer + id[i];
        }

        id = answer.toCharArray();

        // 4단ㄱㅖ
        int start = 0;
        int end = id.length - 1;

        answer = "";
        if (id[start] == '.') {
            start += 1;
        }
        if (id[end] == '.') {
            end -= 1;
        }
        for (int i = start; i <= end; i++) {
            answer = answer + id[i];
        }

        // 5단계
        if (answer == "") {
            answer += "a";
        }
        // 6단계
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15); // 15개 문자로 자르기
            if (answer.charAt(14) == '.') {
                answer = answer.substring(0, 14);
            }
        }
        // 7단계
        if (answer.length() <= 2) {
            char last = answer.charAt(answer.length() - 1);
            while (answer.length() < 3) {
                answer += last;
            }
        }
        System.out.println(answer);

        // 새로운 아이디 출력
        // System.out.println(answer);

    }
}