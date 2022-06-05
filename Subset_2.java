import java.util.Scanner;

public class Subset_2 {
    static int n, input[];
    static boolean isSelected[];

    public static void main(String[] args) {
        // input[] : 입력되는 숫자 배열
        // isSelected[] : 부분집합에 포함, 비포함 여부를 저장한 배열

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        input = new int[n];
        isSelected = new boolean[n];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        subset(0); // 부분집합 생성

    }

    public static void subset(int cnt) {
        if (cnt == n) { // 부분집합 완성!!
            for (int i = 0; i < n; i++) {
                System.out.print((isSelected[i] ? input[i] : "X") + " ");
            }
            System.out.println();
            return;
        }

        // 현재원소 선택!
        isSelected[cnt] = true;
        subset(cnt + 1); // 다음원소로 toss
        // 현재 원소 비선택
        isSelected[cnt] = false;
        subset(cnt + 1); // 다음원소로 Toss

    }
}
