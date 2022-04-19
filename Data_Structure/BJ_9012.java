package Data_Structure;

import java.util.Scanner;
import java.util.Stack;

public class BJ_9012 {
    // 괄호
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int t = 1; t<=T; t++){
            String s = sc.nextLine();
            int size = s.length();

            String res = "YES";
            Stack <Character> stack = new Stack<>(); // 문자열 입력!
            for(int i=0; i<size; i++){
                // System.out.println(i+"번째 : " + s.charAt(i));
                if(s.charAt(i)=='('){
                    //스택에 집어넣기
                    stack.add(s.charAt(i));
                }
                else{
                    // ) 가 입력되면 스택 가장 위의 값이 (인지 확인!
                    if(!stack.isEmpty() && stack.peek()=='('){
                        stack.pop();// 가장 위의 값과 입력된 값 삭제!
                    }
                    else{
                        res ="NO";
                        break;
                    }
                }
            }
            if(!stack.isEmpty()) res="NO";
            System.out.println(res); // 출력
        }
    }
}
