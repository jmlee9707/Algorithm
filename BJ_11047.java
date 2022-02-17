
import java.util.Scanner;
// 동전0
public class BJ_11047 {
    static int N, K, count;
    static int[] coin;
    public static void main(String[] args) {
       // TODO Auto-generated method stub
		Scanner sc  = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        coin = new int [N];
        
        
        int money = K;
        
        for(int i=0; i<N; i++) {
    	   coin[i] = sc.nextInt();
       }

        int i = N-1;
        int res = 0;
        count = 0;
        
        while(i>=0){
        	if(money==0) break;
        	
            // 돈이 가지고 있는 거스름돈 수보다 작고 나누어 떨어지면
            if(money<coin[i]) {
            	i--;
            	continue;
            }

            else if (money>=coin[i] && money/coin[i]>0){
                count = money/coin[i];
                money = money-(coin[i]*count);
                res +=count;
                i--;
            }
        }

        System.out.println(res);
    }


}

