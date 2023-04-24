package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_1620 {
    /*
     * 백준 1620
     * 나는야 포켓몬 마스터 이다솜
     */
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> map = new HashMap<>();
        HashMap<String, Integer> findKey = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            map.put(i, name);
            findKey.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String que = br.readLine();
            // 숫자라면
            if (que.charAt(0) - '0' >= 1 && que.charAt(0) - '0' <= 9) {
                System.out.println(map.get(Integer.parseInt(que)));
            } else {

                System.out.println(findKey.get(que));
            }
        }
    }
}
