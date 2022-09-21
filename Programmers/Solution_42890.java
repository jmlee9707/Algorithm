package Programmers;

import java.util.*;
import java.util.HashSet;

public class Solution_42890 {
    // programmers
    // 2019 카카오 블라인드
    // 후보키

    static public String[][] relation = { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
            { "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
            { "600", "apeach", "music", "2" } };

    public static void main(String[] args) {
        Solution sol = new Solution();
        int answer = sol.solution(relation);
        System.out.println(answer);
    }
}

class Solution {
    static public int column, row, res;
    static public boolean visited[];
    static public String[][] rela;
    static public ArrayList<String> list;

    public int solution(String[][] relation) {

        int answer = 0;
        res = 0;
        column = relation[0].length; // column 갯수
        row = relation.length; // row 갯수
        boolean[] isUnique = new boolean[column];
        visited = new boolean[column];
        list = new ArrayList<String>();

        // int uniCnt = 0;
        rela = relation.clone();
        combination(0);

        // 최소성 제거
        test();
        answer = res;
        return answer;
    }

    public static void combination(int n) {
        if (column == n) {
            // 조합 생성
            makeSet();
            return;
        }
        visited[n] = true;
        combination(n + 1);
        visited[n] = false;
        combination(n + 1);
    }

    // 유일성을 만족하는가?
    public static void makeSet() {
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < row; i++) {
            String str = "";
            for (int j = 0; j < column; j++) {
                if (visited[j]) {
                    str += rela[i][j];
                }
            }
            set.add(str);
        }
        if (set.size() == row) {
            // 최소성 판별
            String str = "";
            for (int i = 0; i < column; i++) {
                if (visited[i])
                    str += "1";
                else
                    str += "0";
            }
            list.add(0, str);
        }
    }

    public static void test() {

        while (list.size() != 0) {
            String str = list.get(0);
            // System.out.println(str);

            for (int i = list.size() - 1; i >= 1; i--) {
                String temp = list.get(i);
                String same = "";
                for (int k = 0; k < column; k++) {
                    if (str.charAt(k) == temp.charAt(k)) {
                        same += String.valueOf(str.charAt(k));
                    } else
                        same += "0";
                }
                if (same.equals(temp) || same.equals(str)) {
                    list.remove(i);
                }
            }

            res++;
            list.remove(0);

        }

    }
}
