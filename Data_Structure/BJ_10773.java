package Data_Structure;

import java.util.Scanner;
import java.util.Stack;

public class BJ_10773 {
    //제로 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        Stack<Integer> stack = new Stack<>(); // stack 생성
        for(int i=0; i<K; i++){
            int a = sc.nextInt();
            if(a==0){
                stack.pop();
            }
            else{
                stack.push(a);
            }
        }

        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        System.out.println(sum);
    }
    
}
