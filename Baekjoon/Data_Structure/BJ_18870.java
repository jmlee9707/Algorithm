package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class BJ_18870 {
    /*
     * 백준 18870
     * 좌표 압축
     */
    static int[][] arr;
    static HashMap<Integer, Integer> map;
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner(" ");

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        map = new HashMap<>();
        set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[i][0] = temp;
            set.add(temp);
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list, (o1, o2) -> o1 - o2); // 거꾸로

        int cnt = 0;

        for (int num : list) {
            map.put(num, cnt);
            cnt++;
        }

        for (int i = 0; i < N; i++) {
            int num = arr[i][0];
            arr[i][1] = map.get(num);
            sj.add(arr[i][1] + "");
        }

        System.out.println(sj.toString());
    }
}
