package Math;

import java.util.Scanner;

public class BJ_1978 {
    // 소수 찾기 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;

        for(int i=0; i<n; i++){
            int num = sc.nextInt();
            int cnt = 0;

            if(num == 1) continue;

            for(int j=num-1; j>=2; j--){
                if(num%j==0) cnt++;
            }

            if(cnt==0) res++;
        }
        System.out.println(res);
  }  
}
