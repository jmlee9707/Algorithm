package Math;

import java.util.Scanner;

public class BJ_2609 {
    // 최대 공약수와 최소 공배수 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        if(a<b){
            int tmp = a;
            a = b;
            b = tmp;
        }

        int GCD = gcd(a,b); // 최대 공약수  
        int LCM = a*b/GCD; 

        // 최소 공배수, least common muliple
        // 최소 공배수는 두 수 a * b /gcd(a,b)
        // 유클리드 호제법

        System.out.println(GCD);
        System.out.println(LCM);

    }

    // 최대 공약수, greatest Common Divisor     
    public static int gcd(int a, int b) {
        // a와 b의 최대공약수를 (a, b)라고 할때 (a,b)의 최대 공약수는 (b,r)의 최대 공약수와 같다 (a>=b)
        // 이때 r = a mod b -> a에 b를 나눈 나머지를 의미 
        // GCD(a,b) = GCD(b,r)
        while(b !=0){
           int r = a%b;
           a = b;
           b = r;
        }
        return a; // 최대 공약수
    }
    
}
