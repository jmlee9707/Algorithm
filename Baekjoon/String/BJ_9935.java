package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ_9935 {
    /*
     * 백준 9935
     * 문자열 폭발
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bombText = br.readLine();

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            st.push(str.charAt(i));
            if (st.size() >= bombText.length()) {
                boolean isSame = true;
                for (int j = 0; j < bombText.length(); j++) {
                    if (bombText.charAt(j) != st.get(st.size() - bombText.length() + j)) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    for (int j = 0; j < bombText.length(); j++) {
                        st.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        if (st.isEmpty())
            System.out.println("FRULA");
        else {
            for (char c : st) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
        br.close();

    }
}
