package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_18870 {
    /*
     * 백준 18870
     * 좌표 압축
     */
    static int N;
    static int[] arr, res;
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        res = new int[N];
        set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
            set.add(n);
        }

        List<Integer> list = new ArrayList<Integer>(set);
        Collections.sort(list);

        for (int i = 0; i < N; i++) {
            int n = arr[i];

            // 이분 탐색

        }

        for (int i = 0; i < N; i++) {
            System.out.print(res[i] + " ");
        }
    }

}
