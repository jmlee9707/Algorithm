import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1289_1 {

	
	// 1289 - sw
	// 원재의 메모리 복구하기
	
	static int tc;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String initB; // 초기화 상태의 비트 
	static String bits; // 입력 받은 비트 
	static int count;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		tc = Integer.parseInt(br.readLine()); // 정수형으로 형 변환 
		
		for(int i=1; i<=tc; i++) {
			
			count = 0;
			bits = br.readLine().trim(); // 공백 제거 
			
			initB = ""; // 초기화 상태의 비트 
	
			for(int j=0; j<bits.length(); j++) {
				initB = initB + "0";
			}
			
			
			// 입력받은 비트와 초기화 상태의 비트를 앞부터 비교하여 같으면 continue 다르면 바꿈
			
			for(int j=0; j<bits.length(); j++) {
				if(bits.charAt(j)==initB.charAt(j)) {
					continue;
				}
				else {
					count++;
					initB = initB.substring(0,j) + switchBits(initB.substring(j));
				}
			}
			
			System.out.println("#" + i + " " + count);
			
		}
	}
	
	public static String switchBits(String sub) {
		
		String returnBits = "";
		for(int i=0; i<sub.length(); i++) {
			if(sub.charAt(i)=='0') {
				returnBits += 1;
			}
			else {
				returnBits += 0;
			}
		}
		
		return returnBits;
	}

}
