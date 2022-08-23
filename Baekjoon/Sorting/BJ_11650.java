package Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BJ_11650 {
    // 좌표 정렬하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] dot = new int[N][2];

        for(int i=0; i<N; i++){
            dot[i][0] = sc.nextInt();
            dot[i][1] = sc.nextInt();
        } 
            
        Arrays.sort(dot, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                else{
                    return o1[0]-o2[0];
                }
            }
                
        });

        for(int i=0; i<N; i++){
            System.out.println(dot[i][0]+" "+dot[i][1]);
        }

        
    }
}
