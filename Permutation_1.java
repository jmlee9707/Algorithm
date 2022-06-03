import java.util.Scanner;

public class Permutation_1 {
    public static void main(String[] args) {
        // 순열 생성법 1 - 반복문을 통한 방법
        // 예 : {1,2,3}을 포함하는 모든 순열 생성!!!
        // 1. 1부터 3까지의 수 선택 시도
        // 2. 기존에 선택된 수 비교, 중복 수 슼킵
        // 3. 다음자리 수 선택 -> 1번부터 3번 반복!

        Scanner sc = new Scanner(System.in);
        int n = 3; // 1~n까지의 수 선택 -> 여기선 3!
        // int r = n; // 몇개의 수 선택? -> r, 여기선 모든 순열!

        for (int i = 1; i <= n; i++) {
            // 첫째자리 수
            for (int j = 1; j <= n; j++) {
                // 둘째자리 수
                if (j == i)
                    continue; // 이미 사용한 수이면 다음수 선택

                for (int k = 1; k <= n; k++) {
                    // 셋째자리 수
                    if (k == i || k == j)
                        continue;

                    System.out.println(i + ", " + j + ", " + k);
                }
            }
        }
    }

}
