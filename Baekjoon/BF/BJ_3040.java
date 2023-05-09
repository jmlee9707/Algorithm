package BF;

import java.util.Scanner;

public class BJ_3040 {
    /*
     * 백준 3040
     * 백설 공주와 일곱 난쟁이
     */

    static int[] dwarfs = new int[9];
    static int[] combi;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        combi = new int[7];
        for (int i = 0; i < 9; i++) {
            dwarfs[i] = sc.nextInt();
        }

        combination(0, 0); // num : 현재 위치, start : 배열의 어디서 부터 탐색?

    }

    public static void combination(int num, int start) {
        if (num == 7) { // 7개 다 뽑았다면
            int sum = 0;
            for (int i = 0; i < 7; i++) {
                sum += combi[i];
            }
            if (sum == 100) {
                for (int i = 0; i < 7; i++) {
                    System.out.println(combi[i]);
                }
            }
            return;
        }

        // num 번쨰 숫자 뽑기
        for (int i = start; i < dwarfs.length; i++) {
            combi[num] = dwarfs[i];
            combination(num + 1, i + 1);
        }

    }
}
