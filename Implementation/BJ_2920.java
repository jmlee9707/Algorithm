package Implementation;

import java.io.BufferedReader;
import java.util.Scanner;

public class BJ_2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[8];
        for(int i=0; i<8; i++){
            arr[i] = sc.nextInt();
        }

        String s="";
        // 올라가는
        if(arr[0]==1){
            int cnt = 0;
            for(int i=0; i<7; i++){
                if(arr[i]-arr[i+1]==-1){
                    cnt++;
                }
            }
            if(cnt==7) s = "ascending";
        }
        // 내려가는
        else if(arr[0]==8){
            int cnt = 0;
            for(int i=0; i<7; i++){
                if(arr[i]-arr[i+1]==1){
                    cnt++;
                }
            }
            if(cnt==7) s = "descending";
        }
        else s = "mixed";

        System.out.println(s);
    }
    
}
