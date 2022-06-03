package BP;

import java.util.Scanner;

public class BJ_2231 {
    // 분해합
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int res = 0;
        for(int i=1; i<N; i++){
            int num = i;
            int sum = i;
            while(num>=1){
                sum += num%10;
                num = num/10;
            }

            if(sum==N){
                res = i;
                break;
            }
        }

        System.out.println(res);

    }
}
