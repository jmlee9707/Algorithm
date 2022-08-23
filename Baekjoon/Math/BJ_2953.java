package Math;

import java.util.Scanner;

public class BJ_2953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ppl[] = new int[6];
        int max = 0;
        int max_num = 0;

        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < 4; j++) {
                ppl[i] += sc.nextInt();
            }

            if (max <= ppl[i]) {
                max = ppl[i];
                max_num = i;
            }
        }

        System.out.println(max_num + " " + max);

    }
}
