package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_17413 {
    /*
     * 백준 17413
     * 단어 뒤집기2
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        boolean isTag = false;
        // StringBuilder sb = new StringBuilder();
        String res = "";

        Stack<Character> stack = new Stack<>(); // stack 선언
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (isTag) {
                // tag안의 단어일 경우
                if (temp == '>')
                    isTag = false;
                res += temp;
            } else {
                if (temp == '<') {
                    isTag = true;
                    while (!stack.isEmpty()) {
                        res += stack.pop();
                    }
                } else if (temp == ' ') {
                    while (!stack.isEmpty()) {
                        res += stack.pop();
                    }
                } else {
                    // stack에 쌓기!
                    stack.push(temp);
                    continue;
                }
                res += temp;
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        System.out.println(res);

    }
}
