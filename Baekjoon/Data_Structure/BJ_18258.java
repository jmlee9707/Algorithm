package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_18258 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            String s = str.nextToken();
            if (str.hasMoreTokens()) {
                que.add(Integer.parseInt(str.nextToken()));
            } else {
                if (s.equals("front")) {
                    if (!que.isEmpty()) {
                        sb.append(que.getFirst()).append("\n");
                    } else {
                        sb.append("-1").append("\n");
                    }
                } else if (s.equals("back")) {
                    if (!que.isEmpty()) {
                        sb.append(que.getLast()).append("\n");
                    } else {
                        sb.append("-1").append("\n");
                    }
                } else if (s.equals("empty")) {
                    if (que.isEmpty())
                        sb.append("1").append("\n");
                    else
                        sb.append("0").append("\n");
                } else if (s.equals("pop")) {
                    if (!que.isEmpty()) {
                        sb.append(que.poll()).append("\n");
                    } else
                        sb.append("-1").append("\n");
                } else if (s.equals("size"))
                    sb.append(que.size()).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
