import java.util.Arrays;
import java.util.Scanner;

public class Permutation_2 {
    static int r; // 뽑아야 하는 순열의 수
    static int n; // 1부터 n까지의 수
    static int numbers[]; // 순열 저장 배열
    static boolean isSelected[]; // 사용중인지 확인하는 배열

    public static void main(String[] args) {
        // 순열 생성법 2 - 재귀를 통한 방법
        // 예 : {1, 2, 3}을 포함하는 모든 순열 생성!!!
        // numbers[] : 순열 저장 배열
        // isSelected[] : 인덱스에 해당하는 숫자가 사용중인지를 저장하는 배열
        // perm(cnt) -> cnt : 현재까지 뽑은 순열 수의 개수

        // Scanner sc = new Scanner(System.in);
        // 여기서는 3
        n = 3; // 1~n까지의 수 선택
        r = 3; // 몇개의 수 선택? -> r
        numbers = new int[r];
        isSelected = new boolean[n + 1]; // 1부터 시작

        permutation(0); // cnt는 여태까지 뽑은 순열의 수
    }

    public static void permutation(int cnt) {
        if (cnt == r) {
            System.out.println(Arrays.toString(numbers));
            return; // 다 뽑으면 재귀 종료
        } else {
            for (int i = 1; i <= n; i++) {
                if (isSelected[i] == true)
                    continue;
                else {
                    numbers[cnt] = i;
                    isSelected[i] = true; // 방문체크
                    permutation(cnt + 1); // 다음 숫자 호출~
                    isSelected[i] = false;
                }
            }

        }

    }

}
