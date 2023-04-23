package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_5430 {
    public static int T, n;
    public static Deque<Integer> deque;
    public static String p;
    public static StringTokenizer st;
    public static boolean reverse;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        outer: for (int t = 0; t < T; t++) {
            p = br.readLine(); // 수행할 함수
            n = Integer.parseInt(br.readLine()); // 배열에 들어 있는 수
            String temp = br.readLine();
            temp = temp.substring(1, temp.length() - 1);
            reverse = false;

            deque = new LinkedList<>();

            st = new StringTokenizer(temp, ",");

            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < p.length(); i++) {

                if (p.charAt(i) == 'R') {
                    reverse = !reverse;
                    continue;
                } else {
                    if (deque.size() != 0)
                        if (reverse)
                            deque.removeLast();
                        else
                            deque.removeFirst();
                    else {
                        sb.append("error \n");
                        continue outer;
                    }
                }
            }
            sb.append("[");
            if (!reverse) {

                while (!deque.isEmpty()) {
                    if (deque.size() >= 2)
                        sb.append(deque.pollFirst() + ",");
                    else
                        sb.append(deque.pollFirst());
                }
            } else {
                while (!deque.isEmpty()) {
                    if (deque.size() >= 2)
                        sb.append(deque.pollLast() + ",");
                    else
                        sb.append(deque.pollLast());
                }
            }

            sb.append("]\n");
        }
        System.out.println(sb);
    }

}
