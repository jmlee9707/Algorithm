package Math;

import java.util.Scanner;

public class BJ_2475 {
    public static void main(String[] args) {
        // 검증수
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        for(int i=0; i<5; i++){
            int num = sc.nextInt();
            sum = sum + num*num;
        }

        int res = sum%10;
        System.out.println(res);

    }
    
}
