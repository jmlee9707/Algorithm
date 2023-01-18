package Data_Structure;

import java.util.Scanner;
import java.util.Stack;

public class BJ_1874 {
    /*
     * 백준 1874
     * 스택 수열
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 1부터 n까지의 수
        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();

        int num = 1;
        for (int i = 0; i < n; i++) {

            int temp = sc.nextInt(); // 수열

            while (temp >= num) {
                stack.push(num);
                num++;
                sb.append("+\n");
            }
            // stack에 있는 수 비교하기
            if (temp < num && temp == stack.peek()) {
                sb.append("-\n");
                stack.pop();
                continue;
            } else if (temp < num && temp != stack.peek()) {
                System.out.println("NO");
                System.exit(0);
            }
        }
        if (stack.isEmpty())
            System.out.println(sb);
        else
            System.out.println("NO");

    }
}
