package String;

import java.util.Scanner;

public class BJ_1316 {
    // 그룹 단어 체커
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.nextLine();
        }
        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean[] alpha = new boolean[26];
            String s = str[i];
            for (int j = 0; j < s.length(); j++) {
                int temp = s.charAt(j) - 97;
                if (j < s.length() - 1) {
                    if (alpha[temp])
                        break;

                    if (s.charAt(j) != s.charAt(j + 1))
                        alpha[temp] = true;

                } else {
                    if (!alpha[temp])
                        count++;
                }

            }
        }

        System.out.println(count);

    }
}
