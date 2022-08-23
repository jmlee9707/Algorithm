package Math;
// LCM, 최소공배수

import java.util.Scanner;

public class BJ_5347 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t<=T; t++){
            
            long a = sc.nextLong();
            long b = sc.nextLong();
    
            long GCD = gcd(Math.max(a, b), Math.min(a, b));
            long lcm = a * b / GCD;

            System.out.println(lcm);
        }
    }

    private static long gcd(long a, long b) {
        while(b!=0){
            long r = a%b;
            a = b;
            b = r; 
        }
        return a;
    }
}
