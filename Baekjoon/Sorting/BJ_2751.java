package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BJ_2751 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i<N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        // Arrays.sort(arr); 시간초과 사용 불가
        Collections.sort(list);

        for(int i=0; i<N; i++){
            sb.append(list.get(i)).append("\n"); // 스트링빌더 사용시 시간 다운
        }

        System.out.println(sb);

    }
}
