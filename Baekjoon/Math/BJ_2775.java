package Math;

import java.util.Scanner;

public class BJ_2775 {
    // 부녀회장이 될테야 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T; t++){
            int floor = sc.nextInt();
            int room = sc.nextInt();
            int ppl = 0;

            int[][] arr = new int[floor+1][room+1];

            for(int i=0; i<=floor; i++){
                for(int j=1; j<=room; j++){
                    if(i>=1){
                        for(int k=1; k<=j; k++){
                            arr[i][j] += arr[i-1][k];
                        }
                    }
                    else if(i==0){
                        arr[i][j] = j;
                    }
                }
            }

            System.out.println(arr[floor][room]);


        }
    }
}
