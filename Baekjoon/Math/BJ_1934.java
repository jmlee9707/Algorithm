package Math;

import java.util.Scanner;

public class BJ_1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T; t++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(a<b){
                int tmp = a;
                a = b;
                b = tmp;
            }
            
            
            int res = a * b / gcd(a, b);
            System.out.println(res);
        }
        
    }
    public static int gcd(int a, int b){
        while(b!=0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}
