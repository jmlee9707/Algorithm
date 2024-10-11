package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1195 {
    /*
     * 백준 1195
     * 킥다운
     */
    static String top, bottom;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        top = br.readLine();
        bottom = br.readLine();
        min = top.length() + bottom.length();  // 최대 길이

        

    }
}
