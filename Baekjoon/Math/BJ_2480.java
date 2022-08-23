package Math;

import java.util.Scanner;
// 주사위 세개
public class BJ_2480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int res = 0;

        if(a==b && b==c && c==a){
            res = 10000 + (a*1000);
        }
        else if(a!=b && b!=c && c!=a){
            int max = Math.max(a, b);
            max = Math.max(max, c);
            res = max*100;
        }
        else{
            int same = 0;
            if(a==b) same = b;
            else if(b==c) same = c;
            else if(a==c) same = a;

            res = 1000+(same*100);
        }
       
        System.out.println(res);
        
    }
}
