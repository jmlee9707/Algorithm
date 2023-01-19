package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class BJ_1213 {
    /*
     * 백준 1213
     * 팰린드롬 만들기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        ArrayList<Character> pro = new ArrayList<>();
        int[] alpha = new int[26];
        for (int i = 0; i < name.length(); i++) {
            // pro.add(name.charAt(i));
            alpha[name.charAt(i) - 65]++;
            // System.out.println(name.charAt(i) - 65);
        }
        boolean oddCnt = false;
        String center = "";
        for (int i = 0; i < 26; i++) {
            if (alpha[i] != 0) {
                if (!oddCnt && alpha[i] % 2 != 0) {
                    center += (char) (i + 65);
                    oddCnt = true;
                    alpha[i]--;
                } else if (oddCnt && alpha[i] % 2 != 0) {
                    System.out.println("I'm Sorry Hansoo");
                    System.exit(0);
                }
                for (int j = 0; j < alpha[i]; j++) {
                    pro.add((char) (i + 65));
                }
            }
        }

        Collections.sort(pro); // 사전순 정렬
        String front = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 1; i <= pro.size(); i++) {
            if ((i + 2) % 2 == 1) {
                // 홀수의 경우
                front += pro.get(i - 1);
            } else {
                stack.add(pro.get(i - 1));
            }

        }
        front += center;
        while (!stack.isEmpty()) {
            front += stack.pop();
        }

        System.out.println(front);

    }
}
