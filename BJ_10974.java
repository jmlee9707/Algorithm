import java.util.Arrays;
import java.util.Scanner;

public class BJ_10974 {
	static int N;
	static int[] numbers;
	static boolean[] isChecked;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 중복을 허용하지 않고 순서가 다르면 다른 경우이니 이문제는 순열로 해결!
		
	
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		function(0, new boolean[N+1]);
	
	}

	public static void function(int cnt, boolean[] isSelected) {
		if(cnt==N) {
			for(int i=0; i<N-1; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println(numbers[N-1]);
			return;
		}
		for(int i= 0; i<N; i++) {
			if(isSelected[i+1]) continue;
			
			// 중복되지않는 수라면 배열에 입력 
			numbers[cnt] =i+1;
			isSelected[i+1] = true;
			
			//다음 cnt 불러오기
			function(cnt+1, isSelected);
			isSelected[i+1] = false;
		}
	}
}
