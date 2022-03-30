import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//import java.io.FileInputStream;

public class SWEA_1208 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = 100; // 크기 

		for (int test_case = 1; test_case <= 10; test_case++) {

			int dump = Integer.parseInt(br.readLine()); // 덤프 횟수 
			int height[] = new int[100];
			

			StringTokenizer st = new StringTokenizer(br.readLine()); // 상자 높이 값 
			
			for (int i = 0; i < size; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}

			while(dump>0) {
				Arrays.sort(height);
				height[size-1]--;
				height[0]++;
				dump--;
			}
			
			Arrays.sort(height);
			
			System.out.printf("#%d %d\n" , test_case, height[size-1]-height[0] );

		}

	}

}
