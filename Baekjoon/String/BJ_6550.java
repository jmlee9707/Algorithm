package String;

import java.util.Scanner;

/**
 * BJ_6550
 * 부분 문자열
 */
public class BJ_6550 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String res = "Yes";
            char[] s = sc.next().toCharArray();
            String t = sc.next();

            int start = 0;

            for (int i = 0; i < s.length; i++) {

                while (true) {
                    if (start >= t.length()) {
                        res = "No";
                        break;
                    }
                    if (s[i] == t.charAt(start)) {
                        start++;
                        break;
                    } else {
                        start++;
                    }
                }
            }

            System.out.println(res);
        }
    }

}