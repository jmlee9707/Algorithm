package Math;

import java.util.Scanner;

public class BJ_10250 {
    //ACM호텔 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T; t++){
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();

            // int [][] room = new int[H+1][W+1];
            boolean [][] visit = new boolean[H+1][W+1];

            int ppl = 0;
            int hres = 0;
            int wres = 0;
                for(int i=1; i<=W; i++){
                    for(int j=1; j<=H; j++){
                        if(ppl>=N) break; // 차있을 경우 다음방

                        visit[j][i] = true;
                        ppl++;
                        hres = j;
                        wres = i;
                    }
                }

            //print
            if(wres>=10){
                System.out.println(hres+""+wres);
            }
            else{
                System.out.println(hres+"0"+wres);
            }
           

           // System.out.println(hres+" "+wres);



        }
    }
}
