import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 단어의 개수
public class BJ_1152 {

	static int count;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine().trim();

		if (st.isEmpty()) {
			System.out.println("0");
		} else {
			System.out.println(st.split(" ").length);
		}
	}

}
