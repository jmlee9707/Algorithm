package Math;

import java.util.Scanner;

public class BJ_2417 {
    /*
     * 백준 2417
     * 정수 제곱근
     * silver 4
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        if (n <= 1)
            System.out.println(n);
        else {
            long q = (long) Math.floor(Math.sqrt(n));
            if (q * q >= n)
                System.out.println(q);
            else
                System.out.println(q + 1);

        }
    }
}
