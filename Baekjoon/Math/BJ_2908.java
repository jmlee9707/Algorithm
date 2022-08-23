package Implementation;

import java.util.Scanner;

// 상수 
public class BJ_2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int na = (a%10)*100 + ((a/10)%10)*10 + (a/100);
        int nb = (b%10)*100 + ((b/10)%10)*10 + (b/100);

        System.out.println(Math.max(na, nb));

    }
}
