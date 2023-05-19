package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11723 {
    /*
     * 백준 11723
     * 집합
     */
    static boolean num[] = new boolean[21];

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String func = st.nextToken();
            if (func.equals("all")) {
                Arrays.fill(num, true);

            } else if (func.equals("empty")) {

                num = new boolean[21];

            } else {
                int find = Integer.parseInt(st.nextToken());
                switch (func) {
                    case "add":
                        num[find] = true;
                        break;
                    case "remove":
                        num[find] = false;
                        break;
                    case "check":
                        String res = num[find] ? "1" : "0";
                        sb.append(res + "\n");
                        break;
                    case "toggle":
                        num[find] = num[find] ? false : true;
                        break;
                    default:
                        break;
                }
            }

        }
        System.out.println(sb);

    }
}
