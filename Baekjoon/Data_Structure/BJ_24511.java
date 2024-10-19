package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_24511 {
    /*
     * 백준 24511
     * queuestack
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" "); // 수열 A

        int[] list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 수열 B

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            if (str[i].equals("0")) {
                deque.addLast(list[i]);
            }
        }

        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 수열 C
        }
        for (int i = 0; i < M; i++) {
            deque.addFirst(arr[i]);
            sb.append(deque.pollLast() + " ");
        }
        System.out.println(sb);

    }
}
