import java.util.Arrays;
import java.util.Scanner;

public class BJ_14696 {
    static int N, A, B; // 라운드 수, 그림의 총 개수  
    static Character winner;
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     N = sc.nextInt();
     for(int r = 1; r<=N; r++){
         A = sc.nextInt();
         int[] cardA = new int[A];
         for(int i = 0; i<A; i++){
             cardA[i] = sc.nextInt();
         }
         
         B = sc.nextInt();
         int[] cardB = new int[B];
         for(int i = 0; i<B; i++){
             cardB[i] = sc.nextInt();
         }

         int shape = 4; // 모양

         for(int i=0; i<4; i++){

            int cntA = 0;
            int cntB = 0;
             for(int j=0; j<A; j++){
                 if(cardA[j]==shape) cntA++;
             }
             for(int j=0; j<B; j++){
                 if(cardB[j]==shape) cntB++;
             }

             if(cntA>cntB){
                 winner = 'A';
                 break;
             }
             else if(cntA<cntB){
                winner = 'B';
                break;
            }
            else if(cntA==cntB){
                shape--;
                if(shape==0 && i==3){
                    winner = 'D';
                }
            }

         }
        System.out.println(winner);
     }   
    }
}
