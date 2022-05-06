package Data_Structure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_11866 {
    // 요세푸스 문제 0
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int k = sc.nextInt();

        sb.append("<");
        Queue<Integer> que = new LinkedList<>(); // queue
        for(int i=1; i<=n; i++){
            que.add(i);
        }
        while(!que.isEmpty()){
            for(int i=1; i<k; i++){
                int tmp = que.peek();
                que.poll();
                que.add(tmp);
            }
            int tmp = que.peek();
            que.poll();
            if(que.size()!=0){
                sb.append(tmp+", ");
            }
            else{
                sb.append(tmp+">");
            }
        }
        System.out.println(sb.toString());
    }
}
