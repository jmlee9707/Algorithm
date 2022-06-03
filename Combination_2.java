import java.util.Arrays;
import java.util.Scanner;

public class Combination_2 {

    static int[] input = { 1, 2, 3, 4 };
    static int[] numbers; // 조합이 저장될 배열

    static int n, r;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = 4; // 원소가 몇개?
        r = 3; // 몇개를 뽑나?

        numbers = new int[r];

        // 예 : {1,2,3,4} 중 원소 3개를 포함하는 모든 조합을 생성!

        // nCr : n개의 원소 중 r개 원소를 갖는 조합 생성
        // input[ ] : n개의 원소를 가지고 있는 배열
        // numbers[] : r개의 크기의 배열, 조합이 저장될 배열

        combination(0, 0);

    }

    public static void combination(int cnt, int start) {

        // cnt : 현재까지 뽑은 조합 원소의 개수
        // start : 조합 시도할 원소의 시작 인덱스

        if (cnt == r) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = start; i < n; i++) {
            numbers[cnt] = input[i];
            combination(cnt + 1, i + 1);
        }
    }
}
