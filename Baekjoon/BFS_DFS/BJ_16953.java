package BFS_DFS;

import java.util.Scanner;
//A->B

public class BJ_16953 {
    static long A, B;
    static int res;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextLong();
        B = sc.nextLong();
        res = 1;

        check();
        System.out.println(res);
    }

    public static void check() {
        long num = B;
        while (num > A) {
            if (num > 10) {
                if ((num - 1) % 10 == 0) {
                    // 1의 자리 수가 1일때
                    num = (num - 1) / 10;
                    res++;
                } else if (num % 2 != 0) {
                    res = -1;
                    return;
                } else {
                    num /= 2;
                    res++;
                }
            } else {
                // num 1~10까지
                if (num % 2 == 0) {
                    num /= 2;
                    res++;
                } else {
                    res = -1;
                    return;
                }
            }
        }
        if (num == A) {
            // res++;
            return;
        } else {
            res = -1;
            return;
        }
    }
}
