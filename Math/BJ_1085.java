package Math;

import java.util.Scanner;

public class BJ_1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int xdis = x;
        if(x>w-x){
            xdis = w-x;
        }
        int ydis = y;
        if(y>h-y){
            ydis = h-y;
        }

        System.out.println(Math.min(xdis, ydis));



    }
}
