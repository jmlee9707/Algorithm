package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11401 {
    public static long div = 1000000007;
    public static void main(String[] args) throws IOException {
        // 이항계수3
        // 모듈러 연산, 페르마 소정리를 이용한 풀이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(st.nextToken());
    
        
        long res = (factorial(n) * mod_inverse((factorial(k)*factorial(n-k))%div, div-2))%div;
        // int res = 0;

        System.out.println(res);
        
    }
    public static long factorial(long num){
        if(num<=1){
            return 1;
        }
        else{
            return (num*factorial(num-1))%div;
        }
    }

    // 역원 구하는 알고리즘, 제곱승 구하기 -> 정말 이건 이해가 안되는걸..
    public static long mod_inverse(long a, long p){ // p = 10005
        long ret = 1;
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
