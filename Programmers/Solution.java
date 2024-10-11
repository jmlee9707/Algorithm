package Programmers;

import java.util.*;

public class Solution {

    // 무손실 압축 알고리즘

    static String alpa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static HashMap<String, Integer> map;
    static ArrayList<Integer> ans;

    public static void main(String[] args) {
        solution();
    }

    public void solution(String msg) {
        ans = new ArrayList<>();
        map = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            map.put(alpa.charAt(i) + "", i + 1);
        }

        int start = 0;
        int num = 27;
        String nowStr = msg.charAt(start) + "";
        String nextStr = "";

        while (start < msg.length()) {
            int cnt = 1;

            ans.add(map.get(nowStr));

            String temp = "";
            while (start + cnt < msg.length()) {
                temp = msg.substring(start, start + cnt + 1);

                if (!map.containsKey(temp)) { // 사전에 없다면
                    map.put(temp, num);
                    num++;
                    break;
                }
                cnt++;
                nextStr = temp;
            }

            System.out.println("현재 : " + nowStr);
            System.out.println("다음 : " + nextStr);
            start += cnt;
            nowStr = nextStr;

        }

        int[] answer = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
            System.out.print(answer[i] + ", ");
        }

    }
}