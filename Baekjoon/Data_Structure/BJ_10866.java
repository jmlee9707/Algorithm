package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_10866 {
    // 덱 
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 명령의 수 
        Deque<Integer> deque = new LinkedList<>();
        
        for(int i=0; i<N; i++){
            String s = br.readLine();

            if(s.equals("pop_front")){ // 가장 앞에 있는 수 빼고 출력
                if(deque.isEmpty()){
                    System.out.println("-1");
                }
                else{
                    System.out.println(deque.pollFirst());
                }
            }
            else if(s.equals("pop_back")){
                if(deque.isEmpty()){
                    System.out.println("-1");
                }
                else{
                    System.out.println(deque.pollLast());
                }
            }
            else if(s.equals("size")){
                System.out.println(deque.size());
            }
            else if(s.equals("empty")){
                if(deque.isEmpty()){
                    System.out.println("1");
                }
                else{
                    System.out.println("0");
                }
            }
            else if(s.equals("front")){
                if(deque.isEmpty()){
                    System.out.println("-1");
                }
                else{
                    System.out.println(deque.peekFirst());
                }
            }
            else if(s.equals("back")){ // 구현 우짜지..
                if(deque.isEmpty()){
                    System.out.println("-1");
                }
                else{
                    System.out.println(deque.peekLast());
                }
            }
            else{
                StringTokenizer st = new StringTokenizer(s);
                String s1 = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                if(s1.equals("push_front")){
                    deque.addFirst(x);
                    // System.out.println(deque.peek());
                }
                else{
                    deque.addLast(x);
                    // System.out.println(deque.peek());
                }
            }
        }
    }
}
