package Math;

import java.util.Scanner;


public class BJ_11050 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        // 이항계수 - 두개의 항을 전개하여 계수로 나타낸 것 -> 조합되어 나오는 값
        int res = factorial(N) / (factorial(N-K) * factorial(K));
        System.out.println(res);
    }

    public static int factorial(int n){
        if(n<=1) {
            return 1;
        }

        return (n * factorial(n-1));
    }
}
