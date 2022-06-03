import java.util.Scanner;

public class Combination_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int n = sc.nextInt(); // 원소가 몇개?
        // int r = sc.nextInt(); // 몇개를 뽑나?

        // int[] input = {1,2,3,4}; // 값이 주어짐!

        // 예 : {1,2,3,4} 중 원소 3개를 포함하는 모든 조합을 생성!
        for (int i = 1; i <= 4; i++) {
            for (int j = i + 1; j <= 4; j++) {
                for (int k = j + 1; k <= 4; k++) {
                    System.out.println(i + ", " + j + ", " + k);
                }
            }
        }

    }
}
