package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_20436 {
    // ZOAC 3
    static int dis, time; // 거리, 시간
    static char sl, sr; // 시작 거리
    static char[][] left = { { 'q', 'w', 'e', 'r', 't', '0' }, { 'a', 's', 'd', 'f', 'g', '0' },
            { 'z', 'x', 'c', 'v', '0', '0' } };
    static char[][] right = { { '0', 'y', 'u', 'i', 'o', 'p' }, { '0', 'h', 'j', 'k', 'l', '0' },
            { 'b', 'n', 'm', '0', '0', '0' } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sl = st.nextToken().charAt(0);
        sr = st.nextToken().charAt(0);

        String input = br.readLine();
        time = 0;

        int leftLoca[][] = new int[2][2]; // {이전위치}, {다음위치}
        int rightLoca[][] = new int[2][2]; // {이전위치}, {다음위치}

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (left[i][j] == sl) {
                    leftLoca[0][0] = i;
                    leftLoca[0][1] = j;
                    // System.out.println(i + " " + j);
                    break;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                if (right[i][j] == sr) {
                    rightLoca[0][0] = i;
                    rightLoca[0][1] = j;
                    // System.out.println(i + " " + j);
                    break;
                }
            }
        }

        for (int t = 0; t < input.length(); t++) {
            char temp = input.charAt(t);
            // left? right? 어디에 위치해 있는지 찾기
            outer: for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 6; j++) {
                    if (temp == left[i][j]) {
                        leftLoca[1][0] = i;
                        leftLoca[1][1] = j;
                        dis = Math.abs(leftLoca[1][0] - leftLoca[0][0]) + Math.abs(leftLoca[1][1] - leftLoca[0][1]);
                        time += 1 + dis;
                        leftLoca[0][0] = i;
                        leftLoca[0][1] = j;
                        break outer;
                    } else if (temp == right[i][j]) {
                        rightLoca[1][0] = i;
                        rightLoca[1][1] = j;
                        dis = Math.abs(rightLoca[1][0] - rightLoca[0][0]) + Math.abs(rightLoca[1][1] - rightLoca[0][1]);
                        time += 1 + dis;
                        rightLoca[0][0] = i;
                        rightLoca[0][1] = j;
                        break;
                    }
                }
            }
        }
        System.out.println(time);

    }
}
