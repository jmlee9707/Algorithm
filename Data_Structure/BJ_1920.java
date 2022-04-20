package Data_Structure;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1920 {
    // 수 찾기
    static int N, M;
    static int [] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
            // System.out.println(arr[i]);
        }
        Arrays.sort(arr);
        //이분탐색
        M = sc.nextInt();

        for(int i=0; i<M; i++){
            int num = sc.nextInt();
            // for(int j=0; j<N; j++){
            //     if(num==arr[j]){
            //         res = 1;
            //         break;
            //     }
            // }
            int res = binarySearch(num);
            System.out.println(res);
        }
    }

    public static int binarySearch(int key){
        // 이분 탐색하기
        // int res = 0;
        int start =0;
        int finish = arr.length-1;
        int mid = 0;
        while(start<=finish){
            mid = (start+finish) / 2;

            if(key==arr[mid]) { // 값을 찾았을 경우
                return 1;
            }
            else if(key<arr[mid]){ // 중간 위치보다 작을 경우
                finish = mid-1;
            }
            else if(key>arr[mid]){ // 중간 위치보다 클 경우 
                start = mid+1;
            }
            
        }

        return 0;
    }
}
