package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15654 {
    /*
     * 백준 15650
     * N과 M (5)
     */
    static int N, M;
    static int[] selectNums;
    static boolean[] isSelected;
    static int[] nums;
    static ArrayList<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N]; // 들어올 수
        selectNums = new int[M];
        isSelected = new boolean[10001]; // 선택 되었는지 안되었는지
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        permutation(0);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void permutation(int cnt) {
        if (cnt == M) {
            String str = "";
            for (int i = 0; i < M; i++) {
                if (i == M - 1)
                    str += selectNums[i];
                else
                    str += selectNums[i] + " ";
            }
            list.add(str);
            return;
        }

        for (int n = 0; n < N; n++) {

            int temp = nums[n];

            if (isSelected[temp])
                continue;
            isSelected[temp] = true;
            selectNums[cnt] = temp;
            permutation(cnt + 1);
            isSelected[temp] = false;
        }
    }
}
