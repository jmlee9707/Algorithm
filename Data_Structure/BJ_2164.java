package Data_Structure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2164 {
    // 카드2
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue <Integer> que = new LinkedList<>();
        for(int i=1; i<=N; i++){
            que.add(i); //
        }

        while(que.size()>1){
            que.poll(); // 제일 위의 카드 버리기
            int tmp = que.peek();
           // System.out.println(tmp);
            que.poll();
            que.add(tmp);
        }

        System.out.println(que.peek());

    }
}
