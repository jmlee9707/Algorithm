package Math;

import java.util.Scanner;

public class BJ_1850 {
    // 최대 공약수
    // 백준 Inputmismatch가 뜨는 이유는 -> type 선언!
    // 백준 출력 초과 - stringbuilder 사용하기 !!
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            long a = sc.nextLong();
            long b = sc.nextLong();

            
            long res = gcd(Math.max(a, b),Math.min(a, b));
            StringBuilder sb = new StringBuilder();

            for(int i=0; i<res; i++){
                sb.append(1);
            }
            System.out.println(sb.toString());
        }
        
    public static long gcd(long a, long b){
        while(b>0){
            long r = a%b;
            a = b;
            b = r;
        }
        return a;

    }
}
