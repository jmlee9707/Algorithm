package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_4949{
    // 균형 잡힌 세상
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String res = "no";
            String s = sc.nextLine();
            if(s.equals(".")) break;

            int size = s.length();
            Stack<Character> stack = new Stack<>(); // stack
            int n = 0;
            while(n<size-1){
                // System.out.println(s.charAt(n));
                if(s.charAt(n)=='(' || s.charAt(n)=='[' || s.charAt(n)=='{'){
                    stack.add(s.charAt(n));
                }
                else if(s.charAt(n)==')'){
                    if(!stack.isEmpty() && stack.peek()=='(') stack.pop();
                    else break;
                }
                else if(s.charAt(n)=='}'){
                    if(!stack.isEmpty() && stack.peek()=='{') stack.pop();
                    else break;
                }
                else if(s.charAt(n)==']'){
                    if(!stack.isEmpty() && stack.peek()=='[') stack.pop();
                    else break;
                }
                n++;
            }
            if(stack.isEmpty() && n==size-1){
                res = "yes";
            }
            System.out.println(res);
        }

    }
}