
import java.util.Arrays;
import java.util.Scanner;

public class Main_2309{

	static int N, MAX, SUM;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = 9;
		MAX = 100;
		int[] height = new int[N];

		for (int i = 0; i < N; i++) {
			height[i] = sc.nextInt();
			SUM += height[i];
		}

		Arrays.sort(height);

		outer: for (int i = N-1; i>=0; i--) {
			for (int j = i-1; j >= 0; j--) {
				int sSum = height[i] + height[j];
				if (SUM-sSum==100) {
					height[i] = MAX;
					height[j] = MAX;
					break outer;
				}
			}
		}
		
		Arrays.sort(height);

		for (int i = 0; i < N - 2; i++) {
			System.out.println(height[i]);
		}
	}
}
