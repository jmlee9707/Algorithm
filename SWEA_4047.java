import java.util.Scanner;

import java.io.*;
// import java.util.*;

public class SWEA_4047 {

    static int T, N;
    static String er = "ERROR";
    
    // 영준이의 카드 카운팅
    // 13장씩 총 52장의 카드 모음

    public static void main(String[] args) throws Exception {

        // System.setIn(new FileInputStream("input_4047.txt"));
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

         for(int tc =1; tc<=T; tc++){
            N = 13;
            int nS = N;
            int nD = N;
            int nH = N;
            int nC = N;

            // S = 1, D = 2, H=3, C=4
            boolean[][] check = new boolean[4][N+1]; // 1~13까지
            String s = sc.next();
            boolean err = false;

            outer : for(int i=0; i<s.length(); i=i+3){
                String sub = s.substring(i, i+3); // 3글자만 가져오기 
                char kind = sub.charAt(0);
                int num = Integer.parseInt(sub.substring(1,3));
                int shape = 5;
                if(kind=='S'){
                    shape = 0;
                }
                else if(kind=='D'){
                    shape = 1;
                }
                else if (kind=='H'){
                    shape = 2;
                }
                else if (kind=='C'){
                    shape = 3;
                }

                if(!check[shape][num]){
                    check[shape][num] = true;
                    if(kind=='S'){
                        nS--;
                    }
                    else if(kind=='D'){
                        nD--;
                    }
                    else if (kind=='H'){
                        nH--;
                    }
                    else if (kind=='C'){
                        nC--;
                    }    
                }
                else if(check[shape][num]){
                    err = true;
                    break outer;
                }
            }

            if(!err){
                System.out.printf("#%d %d %d %d %d\n", tc, nS, nD, nH, nC);
            }
            else{
                System.out.printf("#%d %s\n",tc, er);
            }
        }
    }
}
