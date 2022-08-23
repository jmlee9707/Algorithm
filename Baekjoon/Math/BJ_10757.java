package Math;

import java.math.BigInteger;
import java.util.Scanner;

public class BJ_10757 {
        static BigInteger N;
        // 수 찾기
        static BigInteger M;
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            N = sc.nextBigInteger();
            M = sc.nextBigInteger();

            N = N.add(M);
            System.out.println(N.toString());
        
        }
    
}
