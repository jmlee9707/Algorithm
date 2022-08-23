package Baekjoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2792 {
    // 보석상자
    // M가지 서로 다른 색상 중 한 색상
    // 모든 보석을 N명의 학생들에게 나누어주기
    // 학생은 항상 같은 색의 보석만 가짐, 보석을 받지 못할 수 도 잇음
    // 질투심은 가장 많은 보석을 가져간 학생이 가지고 있는 보석의 개수
    // 질투심이 최소가 되게 보석을 나누어 주기

    // 질투심의 최대는 한 종류에서 보석의 최대 개수
    static int N, M, jealous, left, right, mid, sum; // 학생수, 색상수, 질투심
    static int jewel[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        right = Integer.MIN_VALUE;
        left = 1;

        jewel = new int[M + 1];
        for (int i = 0; i < M; i++) {
            jewel[i] = Integer.parseInt(br.readLine());
            right = right < jewel[i] ? jewel[i] : right;
        }

        // 이분탐색 하면서 최소값 찾기
        while (left <= right) {
            mid = (left + right) / 2; // 중간 값 찾기
            sum = 0;
            for (int i = 0; i < M; i++) {
                sum += jewel[i] / mid;
                if (jewel[i] % mid != 0) { // 한명에게 나머지 몰아주기!
                    sum++;
                }
            }

            if (sum > N) { // 보석을 나눠줄 수 없는 경우
                left = mid + 1;
            } else { // 보석을 나누어 줄 수 있을 때
                right = mid - 1;
                jealous = mid;
            }
        }

        System.out.println(jealous); // 최소 질투심 출력

    }
}
