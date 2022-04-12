package Math;

import java.util.Scanner;

public class BJ_2581 {
    // 소수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int min = N;
        int sum = 0;


        for(int i=M; i<=N; i++){
            int cnt = 0;
            if(i==1) cnt++; // 1로 시작하는 테스트케이스 주의하기 

            for(int j=2; j<i; j++){
                if(i%j==0) { // 소수가 아니면 다음수로 넘어가기 
                    cnt++;
                    break;
                }     
            }
            if(cnt==0){
                sum+=i;
                if(min>i) min = i;
            }
        }

        if(sum==0){
            System.out.println("-1");
        }
        else{
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
