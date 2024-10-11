package Baekjoon.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_5073 {
    /*
     * 백준 5073
     * 삼각형과 세 변
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int[] nums = new int[3];
            nums[0] = Integer.parseInt(st.nextToken());
            nums[1] = Integer.parseInt(st.nextToken());
            nums[2] = Integer.parseInt(st.nextToken());

            if (nums[0] == nums[1] && nums[1] == nums[2] && nums[2] == nums[0]) {
                if (nums[0] == 0)
                    break;
                else
                    bw.write("Equilateral\n");
                continue;
            }

            Arrays.sort(nums);
            if (nums[2] >= nums[0] + nums[1]) {
                bw.write("Invalid\n");
                continue;
            }

            else if (nums[0] != nums[1] && nums[1] != nums[2] && nums[2] != nums[0])
                bw.write("Scalene\n");
            else
                bw.write("Isosceles\n");

        }
        bw.flush();
    }
}
