package Baekjoon.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3079 {
    static int M, N; // 상근이와 친구들, 입국 심사대,
    static int T[]; // 각 입국 심사관이 심사를 하는데 걸리는 시간
    static long max, left, right, mid, res; // 친구들이 심사를 받는데 걸리는 시간의 최솟값

    // 입국심사
    // 한 심사대에서는 한번에 한 사람만 심사를 할 수 있다.
    // 가장 앞에 서 있는 사람은 비어있는 심사대가 보이면 거기로 가서 심사를 받을 수 있다.
    // 단 더 빠른 심사대의 심사가 끝나길 기다린 다음에 그곳으로 가서 심사를 받아도 된다.
    //
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        T = new int[N]; // 입국심사대의 개수
        max = 0L; // 가장 오래 걸리는 시간
        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(br.readLine()); // 입국 심사대 별 걸리는 시간
            max = max < T[i] ? T[i] : max; // 최댓값 저장
        }
        // =========== 입력 끝 ==============

        // 걸리는 총 시간을 기준으로 이분탐색 -> 심사를 받는데 걸리는 시간

        left = 0L; // 데이터 크기가 너무 큼
        right = (max * M) * 1L; // 최대 시간
        res = right;
        long sum;

        // 각 심사대에서 mid 시간 안에 몇명이 심사 받을 수 있는가
        // 각 심사대에서 심사 받을 수 있는 인원을 모두 더해 M보다 크거나 같은지 확인
        while (left <= right) {
            mid = (left + right) / 2;
            sum = 0; // 심사하는 인원

            for (int i = 0; i < T.length; i++) {
                sum += mid / T[i];
                if (sum >= M)
                    break;
            }
            if (sum < M) { // 시간 부족
                left = mid + 1;
            } else {
                right = mid - 1;
                res = mid;
            }
        }

        System.out.println(res);
    }
}