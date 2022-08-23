package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_81301 {
    // 프로그래머스
    // 2021 카카오 채용연계형 인턴십
    // 숫자 문자열과 영단어

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        // ==============================
        int answer = 0;
        // Queue<Integer> que = new LinkedList<>();
        int size = s.length(); // 숫자열의 길이
        int start = 0;
        String[] numbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        while (start < size) {
            // 숫자라면
            if (s.charAt(start) - '0' >= 0 && s.charAt(start) - '0' <= 9) {
                sb.append(s.charAt(start));
                start++;
            }
            // 문자라면
            else {
                for (int i = 0; i < numbers.length; i++) {
                    if (s.charAt(start) == numbers[i].charAt(0)) {
                        if (s.charAt(start) == 't' || s.charAt(start) == 'f' || s.charAt(start) == 's') {
                            if (s.charAt(start + 1) == numbers[i].charAt(1)) {
                                sb.append(i);
                                int cnt = numbers[i].length();
                                start += cnt;
                                break;
                            } else {
                                continue;
                            }
                        } else {
                            int cnt = numbers[i].length();
                            sb.append(i);
                            start += cnt;
                            break;
                        }
                    }
                }
            }
        }

        answer = Integer.parseInt(sb.toString());
        System.out.println(answer);
    }

}