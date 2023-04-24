package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_17219 {
    /*
     * 백준 17219
     * 비밀번호 찾기
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String url = st.nextToken();
            String pass = st.nextToken();

            map.put(url, pass);
        }

        for (int j = 0; j < M; j++) {
            String url = br.readLine();
            sb.append(map.get(url) + "\n");
        }

        System.out.println(sb);
    }
}
