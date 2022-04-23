package Math;

import java.util.Scanner;

public class BJ_18108 {
    //1998년생인 내가 태국에서는 2541년생?!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = n - 543;

        System.out.println(res);
    }
}
