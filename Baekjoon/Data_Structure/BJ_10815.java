package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_10815 {
    /*
     * 백준 10815
     * 숫자 카드
     * silver 5
     * 해시맵 풀이
     */
    static int N, M; // 상근이가 가진 카드 수, 확인해야할 카드 수

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> cards = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            cards.put(temp, temp);
        }

        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (cards.containsKey(temp))
                sb.append("1 ");
            else
                sb.append("0 ");
        }

        System.out.println(sb);

    }
}
