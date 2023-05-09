package BF;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2309 {
    /*
     * 백준 2309
     * 일곱 난쟁이 - 조합
     */
    static int[] selected;
    static int[] dwarfs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        selected = new int[7];
        dwarfs = new int[9];

        for (int i = 0; i < 9; i++) {
            dwarfs[i] = sc.nextInt();
        }
        Arrays.sort(dwarfs);
        combination(0, 0); // num = 7, start : 탐색 시작 숫자

    }

    public static void combination(int num, int start) {
        if (num == 7) {
            int sum = 0;

            for (int i = 0; i < 7; i++) {
                sum += selected[i];
            }
            if (sum == 100) {
                for (int i = 0; i < 7; i++) {
                    System.out.println(selected[i]);
                }
                System.exit(0);
            }
            return;
        }

        for (int i = start; i < dwarfs.length; i++) {
            selected[num] = dwarfs[i];
            combination(num + 1, i + 1);
        }
    }
}
