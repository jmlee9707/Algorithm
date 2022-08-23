package Implementation;

import java.util.Scanner;

public class BJ_7568 {
    static int N;
    static int[][] ppl;
    public static void main(String[] args) {
        // 덩치
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ppl = new int[N][2];
        for(int i=0; i<N; i++){
            ppl[i][0] = sc.nextInt(); // weight
            ppl[i][1] = sc.nextInt(); // height
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int num = 0; // rank
            for(int j=0; j<N; j++){
                if(i==j) {
                    continue;
                }

                // if(ppl[i][0]>ppl[j][0] && ppl[i][1]>ppl[j][1]){
                //     //winner
                //     continue;
                // }
                // else if((ppl[i][0]<ppl[j][0] && ppl[i][1]>ppl[j][1])
                //             ||(ppl[i][0]>ppl[j][0] && ppl[i][1]<ppl[j][1])){
                //     continue;
                // }
                if(ppl[i][0]<ppl[j][0] && ppl[i][1]<ppl[j][1]){
                    num++;
                }
            }
            if(i!=N-1){
                sb.append((num+1)+" ");
            }
            else{
                sb.append(num+1);
            }
        }
        
        System.out.println(sb.toString());
    }
}
