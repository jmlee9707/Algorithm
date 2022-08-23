package Math;

import java.util.Scanner;

// 피보나치 수5
public class BJ_10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int res = fibbo(N);
        System.out.println(res);
    }

    public static int fibbo(int n){
        if(n==1) return 1;
        if(n==0) return 0;

        
        return fibbo(n-1)+fibbo(n-2);
        
    }
}
