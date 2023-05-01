import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11399 {
    /*
     * 백준 11399
     * ATM
     */
    public static int res, N;
    public static int[] line;
    public static int[] time;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        line = new int[N];
        for (int i = 0; i < N; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }
        time = new int[N];

        Arrays.sort(line); // 오름차순 정렬
        time[0] = line[0];

        for (int i = 1; i < N; i++) {
            time[i] = time[i - 1] + line[i];
        }
        res = 0;
        for (int i = 0; i < N; i++) {
            res += time[i];
        }
        System.out.println(res);

    }
}
