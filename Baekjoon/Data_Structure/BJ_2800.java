package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class BJ_2800 {
    /*
     * 백준 2800
     * 괄호 제거
     */
    static String str;
    static ArrayList<String> resList; // 결과 출력
    static ArrayList<BracketList> brackets; // 괄호 쌍 저장 공간
    static int checked[]; // 조합 체크용 배열

    static class BracketList {
        int open;
        int close;

        public BracketList(int open, int close) {
            this.open = open;
            this.close = close;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        brackets = new ArrayList<>();
        resList = new ArrayList<>();

        checkBracket(); // 1. 괄호쌍을 먼저 체크

        Collections.sort(resList); // 사전순 출력
        for (String res : resList) {
            System.out.println(res);
        }

    }

    public static void checkBracket() { // 괄호 가지고 있는 쌍 체크
        Stack<Integer> stack = new Stack<>(); // 괄호 저장할 스택

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.add(i);
            } else if (c == ')') {
                int openN = stack.pop();
                brackets.add(new BracketList(openN, i));
            }
        }

        for (int i = 1; i <= brackets.size(); i++) {
            checked = new int[i];
            combi(i, 0, 0);
        }
    }

    public static void combi(int n, int cnt, int start) {
        // 조합으로 삭제할 괄호 쌍 선택
        if (cnt == n) {
            // 괄호 삭제!
            deleteBracket();
            return;
        }
        for (int i = start; i < brackets.size(); i++) {
            checked[cnt] = i;
            combi(n, cnt + 1, i + 1);
        }

    }

    public static void deleteBracket() {
        int openIdx = -1;
        int closeIdx = -1;
        char repl = '_';
        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < checked.length; i++) {
            int idx = checked[i];

            openIdx = brackets.get(idx).open;
            closeIdx = brackets.get(idx).close;
            sb.setCharAt(openIdx, repl);
            sb.setCharAt(closeIdx, repl);
        }

        String newStr = sb.toString().replaceAll("_", "");
        if (!resList.contains(newStr))
            resList.add(newStr);
        return;

    }
}
