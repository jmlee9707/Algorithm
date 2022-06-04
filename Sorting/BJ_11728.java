package Sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BJ_11728 {
    // 배열 합치기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] arr = new int[n + m];

        String[] arrA = br.readLine().split(" "); // 첫번째 배열 읽기

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrA[i]); // 첫번째 배열 집어 넣기
        }

        String[] arrB = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            arr[i + n] = Integer.parseInt(arrB[i]); // 두번째 배열 집어넣기
        }

        Arrays.sort(arr);// 정렬

        // bufferedWriter 사용하기
        for (int r : arr) {
            bw.write(String.valueOf(r) + " ");
        }

        bw.flush();
        bw.close();
    }
}
