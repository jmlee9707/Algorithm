package Math;

import java.util.Scanner;

public class BJ_5596 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scoreMin = new int[4];
        int[] scoreMan = new int[4];

        int sumMin = 0;
        int sumMan = 0;
        for(int i=0; i<4; i++){
            scoreMin[i] = sc.nextInt();
            sumMin += scoreMin[i];
        }


        for(int i=0; i<4; i++){
            scoreMan[i] = sc.nextInt();
            sumMan += scoreMan[i];
        }

        int max = Math.max(sumMin, sumMan);
        System.out.println(max);

    }
}
