package Sorting;
import java.util.Arrays;
import java.util.Scanner;
// 백설공주와 일곱 난쟁이
public class BJ_3040 {

		static int N, MAX, SUM, delete1, delete2;

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			N = 9;
			MAX = 100;
			int[] shorts = new int[N];

			for (int i = 0; i < N; i++) {
				shorts[i] = sc.nextInt();
				SUM += shorts[i];
			}

			outer: for (int i = N-1; i>=0; i--) {
				for (int j = i-1; j >= 0; j--) {
					int sSum = shorts[i] + shorts[j];
					if (SUM-sSum==100) {
						delete1 = i;
						delete2 = j;
						break outer;
					}
				}
			}
			

			int num = 0;
			while(num<N) {
				if(num == delete1 || num==delete2) {
					num++;
					continue;
				}
				System.out.println(shorts[num]);
				num++;
			}
	}

}
