package DP;

import java.util.Scanner;

public class BJ_5582 {
    // 백준 5582
    // 공통 부분 문자열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        int max = 0;
        int len1 = str1.length();
        int len2 = str2.length();
        // ====== 입력 끝 ==========

        // str1 이 짧은 문자열 str2이 긴 문자열
        // if(str1.length() > str2.length()){
        // String temp = str2;
        // str2 = str1;
        // str1 = temp;
        // }

        // LCS(최장 공통부분 부열)
        // 대각선으로 증가

        int dp[][] = new int[len1 + 1][len2 + 1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = max > dp[i][j] ? max : dp[i][j];
                }
            }
        }

        System.out.println(max);

    }
}
