package DP;

import java.util.Scanner;

public class BJ_2748 {
    /*
     * 백준 2748
     * 피보나치 수2
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // bottom up
        long [] fibo = new long[N+1];
        fibo[0] = 0;
        fibo[1] = 1;
        for(int i=2; i<=N; i++){
            fibo[i] = fibo[i-1] +fibo[i-2];
        }
        System.out.println(fibo[N]);
    }
   
}
