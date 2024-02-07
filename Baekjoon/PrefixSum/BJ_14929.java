package PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14929 {

    /*
     * 백준 14929
     * 귀찮아 (SIB)
     */

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N + 1];
        int[] prefix = new int[N + 1];
        long sum = 0; // int로 하면 Overflow 발생

        prefix[0] = 0;
        nums[0] = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i - 1] + nums[i];
        }

        for (int i = 1; i < N; i++) {
            int temp = (prefix[N] - prefix[i]) * nums[i];
            sum += temp;
        }
        System.out.println(sum);

    }
}
