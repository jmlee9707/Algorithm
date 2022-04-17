package Sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_10816 {
    static int[] list;
    // 숫자카드2
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        list = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++){ // list 입력 받기
            list[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(list); // 오름차순으로 입력 받기 

        int M = Integer.parseInt(br.readLine()); // 카운팅할 정수 개수
        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken()); // 숫자 입력받기
            bw.append((upper_bound(num)-lower_bound(num)+" "));
        }
        bw.flush(); // 출력
    }

    public static int lower_bound(int num){
        int start =0;
        int last = list.length; // 10
        int mid; 

        while(start<last){
            mid = start + (last-start)/2; // 5
            if(num<=list[mid]){
                last = mid;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }

    public static int upper_bound(int num){
        int start = 0;
        int last = list.length; // 10
        int mid; 
        while(start<last){
            mid = start + (last-start)/2;
            if(num>=list[mid]){
                start = mid + 1;
            }
            else{
                last = mid;
            }
        }

        return start;
    }
}
