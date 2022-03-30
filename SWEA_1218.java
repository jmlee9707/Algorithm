
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218 {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			Stack<Character> stack = new Stack<>();
			String s = sc.next();
			
			for(int i=0; i<N; i++) {
				if(s.charAt(i)=='<' || s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[') {
					stack.push(s.charAt(i));
				}
				else {
					Character input = s.charAt(i);
					if(input == '>' && stack.peek()=='<') {
						stack.pop();
					}
					else if(input == ')' && stack.peek()=='(') {
						stack.pop();
					}
					else if(input == '}' && stack.peek()=='{') {
						stack.pop();
					}
					else if(input == ']' && stack.peek()=='[') {
						stack.pop();
					}
					else {
						break;
					}
				}
			}
			
			if(!stack.isEmpty()) {
				System.out.println("#" + tc + " 0");
			}
			else{
				System.out.println("#" + tc + " 1");
			}
		}
	}

}
