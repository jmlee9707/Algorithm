package Math;

import java.math.BigInteger;
import java.util.Scanner;

public class BJ_1271 {
    // 엄청난부자2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        BigInteger m = sc.nextBigInteger();

        // biginteger은 문자열 형태이기 때문에 사칙연산이 불가
        System.out.println(n.divide(m));
        System.out.println(n.remainder(m)); // 나머지 값
    }
}
