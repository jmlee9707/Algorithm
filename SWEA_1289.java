import java.util.Scanner;

public class SWEA_1289 {

	
	// 1289 - sw
	// 원재의 메모리 복구하기
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스
		
		
		for(int i = 1; i<=T; i++) {
			String num = sc.next(); // nextLine()과의 차이점? \n 개행문자까지 읽고, 개행 문자를 버린뒤 나머지를 가져옴 
			int size = num.length();
			int[] res = new int[size]; // 원래 상태 값 
			int count =0; 
			
			// 배열에 해당 메모리 값 저장 
			for(int j=0; j<num.length(); j++) {
				res[j] = num.charAt(j)-'0';
			}
			
			// 초기화 상태의 배열 
			int[] init = new int[size];
			
			for(int j=0; j<num.length(); j++) {
				init[j]=0;
			}
			
			// 비교 
			for(int j=0; j<size; j++) {
				 
				if(res[j]!=init[j] & res[j]==1) {
					for(int k = j; k<size; k++) {
						init[k]=1;
					}
					count++;
				}
				else if(res[j]!=init[j] & res[j]==0) {
					for(int k = j; k<size; k++) {
						init[k]=0;
					}
					count++;
				}
				
				
			}
	
		System.out.printf("#%d %d\n",i, count);
			
		}
	}

}
