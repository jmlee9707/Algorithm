package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BJ_10989 {
    // 수 정렬하기3
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        // ArrayList<Integer> list = new ArrayList<>();
        int arr[] = new int[N];

        for(int i = 0; i<N; i++){
            // list.add(Integer.parseInt(br.readLine()));
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr); //시간초과 사용 불가
        // Collections.sort(list);

        for(int i=0; i<N; i++){
            sb.append(arr[i]).append("\n"); // 스트링빌더 사용시 시간 다운
        }

        System.out.println(sb);
    }
}
