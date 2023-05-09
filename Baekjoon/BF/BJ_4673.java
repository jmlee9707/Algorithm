package Baekjoon.BF;

public class BJ_4673 {
    /*
     * 백준 4673
     * 셀프넘버
     */
    public static void main(String[] args) {
        boolean[] self = new boolean[10001];
        for (int i = 1; i <= 10000; i++) {
            // 생성자
            String s = i + "";
            int temp = i;
            for (int j = 0; j < s.length(); j++) {
                temp += Integer.parseInt(s.charAt(j) + "");
            }
            if (temp <= 10000)
                self[temp] = true;
        }

        for (int i = 1; i <= 10000; i++) {
            if (!self[i])
                System.out.println(i);
        }
    }
}
