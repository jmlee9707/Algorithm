import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1210 {

	static int T, N;
	static int start, fin;
	static int[][] game;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		T = 10;
		N = 100;

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();

			game = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					game[i][j] = Integer.parseInt(st.nextToken());
					if (game[99][j] == 2) {
						start = j; // 시작 값 저장
					}
				}
			}

			int c = start;
			int r = 99;

			while (r > 0) {

				if (c >= 0 && c < N) {
					// 좌측 탐색
					if ((c-1)>= 0 && game[r][c-1] == 1) {
						game[r][c] = 3; // 지나온 자리 체크
						c = c - 1;
					}
					// 우측 탐색
					else if ((c+1)< N && game[r][c+1] == 1) {
						game[r][c] = 3; // 지나온 자리 체크
						c = c + 1;
					}
					// 위쪽 탐색
					else if ((r-1)>= 0 &&game[r - 1][c] == 1) {
						game[r][c] = 3; // 지나온 자리 체크
						r--;
					}

					if (r == 0) {
						fin = c;
						break;
					}

				}
			}
			System.out.println("#" + tc + " " + fin);
		}

	}

}
