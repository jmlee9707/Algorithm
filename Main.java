
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            System.out.println(str);
            int temp = str.charAt(str.length() - 1) - 48;

            System.out.println(temp % 2 == 0 ? "even" : "odd");
        }

    }
}
