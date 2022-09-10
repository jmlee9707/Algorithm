package String;

import java.util.Scanner;

public class BJ_4659 {
    // 비밀번호 발음하기
    // 백준 4659

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            boolean res = true;
            String str = sc.nextLine();
            if (str.equals("end")) {
                System.exit(0);
            }

            // 모음 하나를 반드시 포함하여야 한다.
            if (!str.contains("a") && !str.contains("e") && !str.contains("i") && !str.contains("o")
                    && !str.contains("u")) {
                res = false;
            } else {
                // 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
                for (int i = 0; i < (str.length() - 1); i++) {
                    if (i + 2 < str.length()) {
                        if (((str.charAt(i) == 'a') || (str.charAt(i) == 'e') || (str.charAt(i) == 'o')
                                || (str.charAt(i) == 'i') || (str.charAt(i) == 'u')) &&
                                ((str.charAt(i + 1) == 'a') || (str.charAt(i + 1) == 'e') || (str.charAt(i + 1) == 'o')
                                        || (str.charAt(i + 1) == 'i') || (str.charAt(i + 1) == 'u'))
                                &&
                                ((str.charAt(i + 2) == 'a') || (str.charAt(i + 2) == 'e') || (str.charAt(i + 2) == 'o')
                                        || (str.charAt(i + 2) == 'i') || (str.charAt(i + 2) == 'u'))) {
                            res = false;
                            break;
                        } else if (((str.charAt(i) != 'a') && (str.charAt(i) != 'e') && (str.charAt(i) != 'o')
                                && (str.charAt(i) != 'i') && (str.charAt(i) != 'u')) &&
                                ((str.charAt(i + 1) != 'a') && (str.charAt(i + 1) != 'e') && (str.charAt(i + 1) != 'o')
                                        && (str.charAt(i + 1) != 'i') && (str.charAt(i + 1) != 'u'))
                                &&
                                ((str.charAt(i + 2) != 'a') && (str.charAt(i + 2) != 'e') && (str.charAt(i + 2) != 'o')
                                        && (str.charAt(i + 2) != 'i') && (str.charAt(i + 2) != 'u'))) {
                            res = false;
                            break;
                        }
                    }

                    // 3. 같은 글자가 연속적으로 두번 오면 단되나 ee와 oo는 허용한다.
                    if (str.charAt(i) == 'e' || str.charAt(i) == 'o') {
                        continue;
                    } else {
                        if (str.charAt(i) == str.charAt(i + 1)) {
                            res = false;
                            break;
                        }

                    }
                }
            }
            if (res) {
                System.out.println("<" + str + "> is acceptable.");
            } else {
                System.out.println("<" + str + "> is not acceptable.");
            }
        }
    }
}
