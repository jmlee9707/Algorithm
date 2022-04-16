package BP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_1018 {
    // 체스판 다시 칠하기
    static char[][] chess;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

      

        chess = new char[N][M];

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                chess[i][j] = s.charAt(j);
            }
        }

        int min = 65; // 칠해야하는 최소 개수
        int cnt = 0; // 칠하는 수 세기

        for(int x = 0; x<=N-8; x++){
            for(int y = 0; y<=M-8; y++){
                cnt = color(x, y);

                // System.out.println("x:"+ x + ", y : "+y+", cnt : "+cnt);
                min = Math.min(min, cnt);
            }
        }

        // System.out.println(chess[8][22]);
        System.out.println(min);
        
    }

    public static int color(int r, int c){
        
        int cnt = 0;
        char color = chess[r][c]; // 체스판 시작 색깔 정하기
        // int sx = r;
        // int cx = c;

        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(i%2==0){
                    // 짝수줄이면
                    if(j%2==0 && color!=chess[r+i][c+j]){// 짝수칸 
                        cnt++;
                    }
                    
                    else if(j%2!=0 && color==chess[r+i][c+j]){ // 홀수칸 
                        cnt++;
                    }
                }
                else{
                    // 홀수줄이면
                    if(j%2==0 && color==chess[r+i][c+j]){ // 짝수칸
                        cnt++;
                    }
                    else if(j%2!=0 && color!=chess[r+i][c+j]){ // 홀수칸
                        cnt++;
                    }
                }
            }
        }

        return Math.min(cnt, 64-cnt);
    }
}

