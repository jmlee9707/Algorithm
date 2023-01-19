package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2941 {
    /*
     * 백준 2941
     * 크로아티아 알파벳
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String alpha = br.readLine();
        int cnt = 0; // 크로아티아 알파벳의 개수
        int start = 0;
        while (start < alpha.length()) {
            char temp = alpha.charAt(start);

            if (start + 2 < alpha.length() && alpha.substring(start, start + 3).equals("dz=")) {
                start += 2;
            } else if (start + 1 < alpha.length()) {
                String slice = alpha.substring(start, start + 2);
                if (slice.equals("c=") || slice.equals("c-") || slice.equals("d-") || slice.equals("lj")
                        || slice.equals("nj") || slice.equals("s=") || slice.equals("z=")) {
                    start++;
                }
            }

            cnt++;
            start++;
        }

        System.out.println(cnt);

    }
}
