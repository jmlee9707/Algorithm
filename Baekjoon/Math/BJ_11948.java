package Math;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_11948 {
    static int[] science;
    static int[] society;

    public static void main(String[] args) {
        science = new int[4];
        society = new int[2];
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            science[i] = sc.nextInt();
            sum += science[i];
        }
        Arrays.sort(science);
        sum = sum - science[0];

        for (int i = 0; i < 2; i++) {
            society[i] = sc.nextInt();
            sum += society[i];
        }

        sum = sum - Math.min(society[0], society[1]);

        System.out.println(sum);

    }
}
