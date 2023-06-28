package BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2512 {

    static int N, total, sum, maxMoney, res; // 지방의 수, 총액
    static int[] money;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        money = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        sum = 0;
        maxMoney = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {

            money[i] = Integer.parseInt(st.nextToken());
            sum += money[i];
            maxMoney = Math.max(maxMoney, money[i]);
        }

        total = Integer.parseInt(br.readLine());

        if (sum <= total) { // 1. 모든 요청이 배정될 수 있는 경우 그대로 배정
            System.out.println(maxMoney);
            System.exit(0);
        }

        // 2. 모든 요청이 배정될 수 없는 경우 특정 정수 상한액 계산
        res = 0;
        binary();

        System.out.println(res);
    }

    public static void binary() {
        int start = 1;
        int end = maxMoney;
        int middle = 0;

        while (start <= end) {
            middle = (start + end) / 2;
            int tempSum = calc(middle);

            if (tempSum > total) {
                end = middle - 1;
            } else if (tempSum < total) {
                res = Math.max(middle, res);
                start = middle + 1;
            } else {
                res = middle;
                break;
            }
        }
    }

    public static int calc(int highest) {
        int s = 0;
        for (int i = 0; i < N; i++) {
            s += Math.min(highest, money[i]);
        }
        return s;
    }
}