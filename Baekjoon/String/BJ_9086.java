package String;

import java.util.Scanner;

public class BJ_9086 {
    // 문자열
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= t; i++) {
            String s = sc.nextLine();
            char first = s.charAt(0);
            char last = s.charAt(s.length() - 1);
            System.out.print(first);
            System.out.println(last);
        }

    }
}
