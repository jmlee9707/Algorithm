package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11051_1 {
    public static int div = 10007;
    public static void main(String[] args) throws IOException {
        // 이항계수2
        // 모듈러 연산, 페르마 소정리를 이용한 풀이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
    
        // 이항계수 nCk = n!/(n-k)!*k!
        // 10007로 나눈 나머지?
        // 모듈러 연산 => 나눗셈 연산은 없음
        // (a+b)mod m = ((a mod m) + (b mod m))mod m
        // (a*b)mod m = ((a mod m) * (b mod m))mod m

    
        // (factorial(n-k)*factorial(k)) 의 역수를 구하기
        // 역수를 구하면 (a*b)mod m = ((a mod m) * (b mod m))mod m 식을 만족할 수 있음
        // 이때 사용할 수 있는 것이 페르마의 소정리 
        // int mul = factorial(n) / (factorial(n-k)*factorial(k));
        // System.out.println(res);

        // 페르마의 소정리 
        // p가 소수이고 a가 p로 나누어지지 않는 정수이면 다음과 같은 특징을 가진다.
        // a^p ≡ a (mod p) → a^p mod p ≡ a mod p
        // a^p-1 ≡ 1 (mod p)
        // a^p-2 ≡ a^-1 (mod p) → a의 역원은 ** a^p-2 (mod p)**
        // 이때 이 문제에서 p = 10007

        // a = k!*(n-k)!, p = 10007, (k!*(n-k)!)^-1 = (k!*(n-k)!)^10007-2
        

        // 최종적으로 계산하려는 식
        // n!/((k!*(n-k)!)) * mod p = (n! * (k!*(n-k)!)^-1) mod p
        // = ((n! mod p) * (k!*(n-k)!) mod p) mod p
        // = ((n! mod p) * (k!*(n-k)!)^10007-2 mod p) mod p

        /*
        *   n! / ((n-k)! * k!)   ->   n! * ((n-k)! * k!)^(-1) 으로 변환
        *   ((n-k)! * k!)^(-1) == ((n-k)! * k!)^(p-2) 동치 
        */

        int res = (factorial(n) * mod_inverse((factorial(k)*factorial(n-k))%div, div-2))%div;
        // int res = 0;

        System.out.println(res);
        
    }
    public static int factorial(int num){
        if(num<=1){
            return 1;
        }
        else{
            return (num*factorial(num-1))%div;
        }
    }

    // 역원 구하는 알고리즘, 제곱승 구하기 -> 정말 이건 이해가 안되는걸..
    public static int mod_inverse(int a, int p){ // p = 10005
        int ret = 1;
        while(p>0){ 
            if(p%2==1){ // 지수가 홀수라면
                ret = ret * a;
                p--;
                ret = ret%div;
            }
            a = a*a;
            a = a%div;
            p = p/2;
        }

        return ret;
    }

}
