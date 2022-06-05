package ExhaustiveSearch;

import java.util.Scanner;

public class BJ_1436 {
    // 영화감독 숌

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        int num = 1; // 증가할 숫자

        while (true) {
            if (String.valueOf(num).contains("666")) {
                // int를 문자열로 변환하여 666이 포함되었는지 확인!
                cnt++;
            }
            // 만약 cnt의 값과 찾고자 하는 순서의 n이 같다면 break
            if (cnt == n) {
                break;
            }

            num++;
        }

        System.out.println(num);
    }

}
