package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_10845 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> que = new LinkedList<>();
        for(int i=0; i<N; i++){
            String s = br.readLine();
            if(s.equals("pop")){
                if(que.isEmpty()){
                    System.out.println("-1");
                }
                else{
                    System.out.println(que.poll());
                }
            }
            else if(s.equals("size")){
                System.out.println(que.size());
            }
            else if(s.equals("empty")){
                if(que.isEmpty()){
                    System.out.println("1");
                }
                else{
                    System.out.println("0");
                }
            }
            else if(s.equals("front")){
                if(que.isEmpty()){
                    System.out.println("-1");
                }
                else{
                    System.out.println(que.peek());
                }
            }
            else if(s.equals("back")){ // 구현 우짜지..
                if(que.isEmpty()){
                    System.out.println("-1");
                }
                else{
                    for(int j=0; j<que.size()-1; j++){
                        int tmp = que.poll();
                        que.offer(tmp);
                    }
                    int tmp = que.poll();
                    System.out.println(tmp);
                    que.offer(tmp);

                }
            }
            else{
                StringTokenizer st = new StringTokenizer(s);
                String s1 = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                que.add(x);
            }
        }
    }
}
