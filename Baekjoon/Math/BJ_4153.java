package Math;

import java.util.Scanner;

//직각삼각형
public class BJ_4153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if(a==0&&b==0&&c==0){
                break;
            }

            String ans = "wrong";
            if(a>b && a>c && a*a == (b*b) + (c*c)){
                ans = "right";
            }
            else if(b>a && b>c && b*b == (a*a) + (c*c)){
                ans = "right";
            }
            else if(c>b && c>a && c*c == (b*b) + (a*a)){
                ans = "right";
            }
            
            System.out.println(ans);

        }
    }
}
