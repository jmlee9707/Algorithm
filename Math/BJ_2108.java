package Math;

import java.util.Arrays;
import java.util.Scanner;


public class BJ_2108 {
    // 통계학
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        int [] arr = new int[8001];

        int sum = 0;
        for(int i=0; i<N; i++){
            num[i] = sc.nextInt();
            sum += num[i]; // 합계 구하기
            arr[num[i]+4000]++; // 최빈값 찾기
        }

        int avg = (int)Math.round((double)sum/N); // 산술평균

        Arrays.sort(num);
        int lot = 0;
        boolean flag = false; // 최빈값 등장 변수

        int maxCnt = 0;
        int i = N-1;
        int cnt = 1;

        // 최빈 값
        for(int i=0; i<8001; i++){

        }
    
        System.out.println(avg); // 산술평균
        System.out.println(num[N/2]); // 중앙값
        System.out.println(lot); // 최빈값
        System.out.println(num[N-1]-num[0]); // 범위 출력



    }
}
