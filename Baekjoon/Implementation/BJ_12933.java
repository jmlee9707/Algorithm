package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_12933 {
    /*
     * 백준 12933
     * 오리
     */
    static String str;
    static boolean[] visited;
    static char[] duck = { 'q', 'u', 'a', 'c', 'k' };
    static int cnt;
    static ArrayList<Character> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        visited = new boolean[str.length()];

        cnt = 0;

        if (str.length() % 5 != 0 || str.charAt(0) != 'q') { // 울음소리는 무조건 5의 배수
            System.out.println("-1");
            System.exit(0);
        }

        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        int num = 0;

        while (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == duck[num]) {
                    num = (num + 1) % 5;
                    list.remove(i);
                    i--;
                }
            }
            if (num == 0)
                cnt++;
            else {
                System.out.println("-1");
                System.exit(0);
            }
        }

        System.out.println(cnt);
    }

}
