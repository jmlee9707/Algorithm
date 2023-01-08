package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_20546 {

    /*
     * 백준 20546
     * 🐜 기적의 매매법 🐜
     */

    static String answer; // 결과 값
    static String[] stock;
    static int jc, sc; // 성민이와 준현이의 현금 값
    static int numJ = 0, numS = 0; // 성민이와 준현이의 주식 수

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cash = Integer.parseInt(br.readLine()); // 주어진 현금 입력 값
        // 모든 입력은 1000 이하의 양의 정수
        stock = br.readLine().split(" ");

        jc = cash; // 초기화
        sc = cash;

        // int three = 0; // 3일 연속 증가? or 3일 연속 하락?

        for (int i = 0; i < 14; i++) {
            // 14일간 반복
            int money = Integer.parseInt(stock[i]); // 현재 주가

            // 준현 주식 구매
            if (jc != 0 && jc / money > 0) { // 만약 준현이가 주식을 살 수 있다면
                numJ += jc / money;
                jc = jc % money;
            }

            // 성민 주식 구매, 1월 3일부터 거래 가능
            if (i > 2) {
                sTrading(money, i);
            }
        }

        // 총 금액 결산
        jc += numJ * Integer.parseInt(stock[13]);
        sc += numS * Integer.parseInt(stock[13]);

        // System.out.println(jc + " " + sc);

        if (jc > sc) {
            System.out.println("BNP");
        } else if (jc == sc) {
            System.out.println("SAMESAME");
        } else {
            System.out.println("TIMING");
        }
    }

    public static void sTrading(int money, int cnt) {
        // 3일 연속 상승?
        int num3 = Integer.parseInt(stock[cnt - 3]); // 3일전
        int num2 = Integer.parseInt(stock[cnt - 2]); // 2일전
        int num1 = Integer.parseInt(stock[cnt - 1]); // 1일전

        if (numS != 0 && num1 < money && num2 < num1 && num3 < num2) {
            // 3일 연속 상승했다면 판매!
            sc += money * numS;
            numS = 0; // 전량 매도

        } else if (sc != 0 && sc / money > 0 && num1 > money && num2 > num1 && num3 > num2) {
            // 3일 연속 하락했다면 모두 구매!
            numS += sc / money;
            sc = sc % money;
        }

    }
}
