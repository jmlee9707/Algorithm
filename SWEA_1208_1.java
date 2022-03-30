import java.util.Scanner;
//import java.io.FileInputStream;

public class SWEA_1208_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int res = 100; // 결과값

			int dump = sc.nextInt();
			int height[] = new int[100];

			for (int i = 0; i < 100; i++) {
				height[i] = sc.nextInt();
			}

			int max_idx = -1;
			int min_idx = -1;

			for (int i = 0; i <= dump; i++) {

				if (i != 0) {
					height[max_idx]--;
					height[min_idx]++;
				}
				
				int max = 0;
				int min = 101;

				// 최대, 최소 찾기
				for (int j = 0; j < 100; j++) {

					if (height[j] > max) {
						max = height[j];
						max_idx = j;
					} 

					if (height[j] < min) {
						min = height[j];
						min_idx = j;
					}

				}

				res = height[max_idx] - height[min_idx];

				if (res <= 1) {
					break;
				}

			}
			System.out.println("#" + test_case + " " + res);

		}

	}

}
