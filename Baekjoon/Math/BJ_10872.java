package Math;

import java.util.Scanner;

public class BJ_10872 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int res = factorial(N);
        System.out.println(res);
    }

    public static int factorial(int n){
        if(n<=1) return 1;
        return n*factorial(n-1);
    }
}
