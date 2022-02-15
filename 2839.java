import java.util.Scanner;

public class Main_2839{

	static int N, sugar, res;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int kg5 = 0;
		int kg3 = 0;

		N = sc.nextInt();

		sugar = N; // 남은 설탕의 양

		while (true) {
			if (sugar % 5 == 0) {
				kg5 = sugar / 5;
				res = kg3 + kg5;
				break;
			} 
			else {
				sugar = sugar-3;
				kg3++;
			}
			
			if(sugar<0) {
				res = -1;
				break;
			}
		}
		
		System.out.println(res);
	}

}
