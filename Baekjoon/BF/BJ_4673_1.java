package Baekjoon.BF;

public class BJ_4673_1 {
    /*
     * 백준 4673
     * 셀프 넘버
     */
    static boolean[] selfnum = new boolean[10001];

    public static void main(String[] args) {
        // 생성자가 없는 숫자를 셀프 넘버
        // n + n의 각자리수 합 => 새로운 숫자
        for (int i = 1; i < selfnum.length; i++) {
            if (selfnum[i])
                continue;
            checkSelf(i);
        }

        for (int i = 1; i < selfnum.length; i++) {
            if (!selfnum[i])
                System.out.println(i);
        }
    }

    public static void checkSelf(int n) {
        int sum = n;
        while (n >= 1) {
            sum = sum + (n % 10);
            n /= 10;

            if (sum > 10000)
                return;
        }
        selfnum[sum] = true;
        checkSelf(sum);
    }
}
