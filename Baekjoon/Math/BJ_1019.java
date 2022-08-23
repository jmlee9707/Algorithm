package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 책 페이지
public class BJ_1019 {
    static long start, end, res, mul;
    static long[] num; // 횟수를 넣어주는 배열

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        start = 1;
        end = Long.parseLong(st.nextToken());

        num = new long[10];
        res = 0; // 결과 값
        mul = 1; // 곱할 값

        // if(start == 0) start =1; // 이문제에선 항상 시작은 1

        while (start <= end) {
            // 시작값을 0으로 만들어 주기
            while (start % 10 != 0 && start <= end) { //
                cal(start);
                start++;
            }
            if (start > end)
                break;
            // 시작값을 9로 만들어 주기
            while (end % 10 != 9 && start <= end) {
                cal(end);
                end--;
            }

            long diff = end / 10 - start / 10 + 1; // 0-9의 횟수 
            for (int i = 0; i < 10; i++) {
                num[i] = num[i] + diff * mul;
            }

            mul *= 10; // 자리수 이동
            start /= 10; // 자리수 변화 
            end /= 10; // 자리수 변화 
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(num[i] + " ");
        }

    }

    public static void cal(long n) {
        for (long i = n; i > 0; i /= 10) {
            String s = Long.toString(i);
            int tmp = s.charAt(s.length() - 1) - '0'; // 일의 자리 저장
            num[tmp] +=  mul;
        }
    }
}
