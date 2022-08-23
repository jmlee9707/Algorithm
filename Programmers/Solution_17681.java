package Programmers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.BinaryOperator;

public class Solution_17681 {
    // 비밀지도
    // 지도는 한변의 길이가 n인 정사각형 배열 형태로 각 칸은 " " 또는 "#"
    // 전체 지도는 두장의 지도를 겹쳐서 얻을 수 있다
    // 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서 벽
    // 모두 공백인 부분은 전체 지도에서 공백
    // 지도 1과 지도 2는 각각 정수 배열로 암호화
    // 암호화 된 배열은 지도의 각 가로줄에서 벽 1, 공백 0으로 부호화 했을 때 얻어지는 이진수에 해당하는 값의 배열

    static int n = 5;
    static int[] arr1 = { 9, 20, 28, 18, 11 };
    static int[] arr2 = { 30, 1, 21, 17, 28 };
    static String[] answer;

    public static void main(String[] args) {
        answer = new String[n];
        char[][] map = new char[n][n]; // 지도 배열 하나 만들기

        for (int i = 0; i < n; i++) {
            // 각각의 수를 이진수로 만들기
            int start = n - 1;
            int num1 = 0;
            int num2 = 0;

            while (start >= 0) {
                num1 = arr1[i] % 2;
                arr1[i] = arr1[i] / 2; // 몫은 다음으로 넘기기

                num2 = arr2[i] % 2;
                arr2[i] = arr2[i] / 2;

                if (num1 == 0 && num2 == 0) {
                    // 둘다 공백이면 지도는 공백
                    map[i][start] = ' ';
                } else {
                    map[i][start] = '#';
                }
                start--;
            }
        }

        for (int i = 0; i < n; i++) {
            answer[i] = "";
            for (int j = 0; j < n; j++) {
                answer[i] += map[i][j];
            }
            System.out.println(answer[i]);
        }

    }
}