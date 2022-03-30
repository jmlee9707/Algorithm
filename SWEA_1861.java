import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1861{
	static int T, N, max, count, res;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];

			for (int i = 0; i < N; i++) {

				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max = 1;
			res = N*N;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					int x = i; // 
					int y = j;
					int initX = i; // 현재 위치 저장 
					int initY = j;

					count = 1;

					while(true) {
					for (int d = 0; d < 4; d++) {
							int nr = x + deltas[d][0];
							int nc = y + deltas[d][1];

							if (nr < N && nc < N && nr >= 0 && nc >= 0 && arr[nr][nc] - arr[x][y] == 1) {
								count++;
								x = nr;
								y = nc;
								d = 0;
							}
					}
					break;
					}
					
					if (count > max) { // 이전 방 이동횟수보다 현재 방 이동횟수가 더 크면 저장
						max = count;
						res = arr[initX][initY];
					}
					else if(count==max) {
						if(arr[initX][initY]<res) {
							res = arr[initX][initY];
					}
					
					}
				}
			}
			
			System.out.println("#" + tc + " " + res + " " + max);
		}
	}

}
