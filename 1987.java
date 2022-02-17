import java.util.HashSet;
import java.util.Scanner;

public class Main_1987 {

	static int R, C, answer;
	static char[][] map;
	static boolean[][] visit;
	static HashSet<Character> set;
	
	static int[] dr = {-1, 0, 1, 0}; // 상 우 하 좌 
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		set = new HashSet<>();
		
		R = sc.nextInt();
		C = sc.nextInt();
		
		map = new char[R][C];
		visit = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		dfs(0, 0, 1);
		
		System.out.println(answer);
		
	}
	
	private static void dfs(int r, int c, int d) {
		int s = set.size(); //0
		set.add(map[r][c]); //1
		
		if(s==set.size()) return; // 중복된 데이터가 입력되었다면
		
		if(answer<d) answer = d; // 이동한 거리값 얻기 
		visit[r][c] = true;
		int nr, nc;
		
		for(int i=0; i<4; i++) { // 네방향 인덱스 표현 
			nr = r + dr[i];
			nc = r + dc[i];
			
			if(nr<0 || nr>=R || nr<0 || nc>=C) continue;
			
			if(!visit[nr][nc]) {
				dfs(nr, nc, d+1); // 새로운 인덱스로 출발 
			}
			
		}
		
		set.remove(map[r][c]);
		visit[r][c] = false;
	}

}
