package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_2824 {
    /*
     * 백준 2824
     * 최대공약수
     */
    static BigInteger A, B;
    static int N, M;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new BigInteger("1");
        B = new BigInteger("1");
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            A = A.multiply(new BigInteger(st.nextToken()));
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            B = B.multiply(new BigInteger(st.nextToken()));
        }
        gcb(A, B);
    }

    public static void gcb(BigInteger big, BigInteger small) {

        // BigInteger r = new BigInteger("0");
        String s = big.gcd(small).toString();

        // String s = big + "";

        if (s.length() <= 9)
            System.out.println(s);
        else
            System.out.println(s.substring(s.length() - 9, s.length()));
    }
}
