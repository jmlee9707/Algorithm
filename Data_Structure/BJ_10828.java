package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_10828 {
    // 스택
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack <Integer> stack = new Stack<>();
        for(int i=0; i<N; i++){
            String s = br.readLine();
            if(s.equals("pop")){
                if(stack.isEmpty()){
                    System.out.println("-1");
                }
                else{
                    System.out.println(stack.pop());
                }
            }
            else if(s.equals("size")){
                System.out.println(stack.size());
            }
            else if(s.equals("empty")){
                if(stack.isEmpty()){
                    System.out.println("1");
                }
                else{
                    System.out.println("0");
                }
            }
            else if(s.equals("top")){
                if(stack.isEmpty()){
                    System.out.println("-1");
                }
                else{
                    System.out.println(stack.peek());
                }
            }
            else{
                StringTokenizer st = new StringTokenizer(s);
                String s1 = st.nextToken();
                int x = Integer.parseInt(st.nextToken());
                stack.add(x);
            }
        }

    }
}
