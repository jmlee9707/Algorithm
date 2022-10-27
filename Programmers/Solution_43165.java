package Programmers;

import java.util.*;

public class Solution_43165 {

    static int[] numbers;
    static int target;
    static int ans;

    // 프로그래머스
    // 타겟 넘버
    public static void main(String[] args) {
        ans = 0;
        dfs(numbers, target, 0, 0);
        System.out.println(ans);
    }

    static public void dfs(int[] numbers, int target, int cnt, int sum) {
        if (cnt == numbers.length) {
            if (sum == target)
                ans++;
            return;
        }
        sum += numbers[cnt];
        dfs(numbers, target, cnt + 1, sum);
        sum -= numbers[cnt];
        sum -= numbers[cnt];

        dfs(numbers, target, cnt + 1, sum);
    }
}
