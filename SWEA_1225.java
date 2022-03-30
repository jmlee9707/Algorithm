import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1225 {

	static int T, N;
	static int front, num, cycle;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
//		T = sc.nextInt();

		for (int tc = 1; tc <= 10; tc++) {

			N = sc.nextInt();
			
			// 큐에 8자리 암호 add
			Queue<Integer> que = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				que.add(sc.nextInt());
			}
			
			num = 0;

			while (true) {
				cycle = num % 5 + 1;
				if (que.peek() - cycle > 0) {
					front = que.poll() - cycle;
					que.add(front);
					num++;
				} else { // 0보다 작아지거나 0일 경우
					que.poll();
					front = 0;
					que.add(front);
					break;
				}
			}

			System.out.print("#" + N + " ");
			while (!que.isEmpty()) {
				System.out.print(que.poll() + " ");
			}
			System.out.println();

		}
	}

}
