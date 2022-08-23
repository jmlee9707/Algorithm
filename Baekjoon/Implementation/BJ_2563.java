import java.util.Scanner;
// 색종이
public class BJ_2563 {
	static int N;
	static int [][] paper;
	static int size;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		size = 0; // 검은 종이 사이즈 

		paper = new int[100][100];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				paper[i][j]=0;
			}
		}
		
		for(int t = 0; t<N; t++) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int i=x; i<x+10; i++) {
				for(int j=y; j<y+10; j++) {
					if(paper[i][j]!=1) {
						paper[i][j] =1;
						size++;
					}
					else {
						continue;
					}
				}
			}
		}
	
		System.out.println(size);
		
	}

}
