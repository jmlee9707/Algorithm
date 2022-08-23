package Implementation;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 기상캐스터
public class BJ_10709 {
    static int H, W;
    static char[][] sky;
    static int[][] res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        sky = new char[H][W];
        res = new int[H][W];
        for(int i=0; i<H; i++){
            String str = br.readLine();
            for(int j=0; j<W; j++){
                sky[i][j] = str.charAt(j);
            }
        }
        // 구름 체크
        for(int i=0; i<H; i++){
           cloud(i);
        }

        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static void cloud(int r){
        // int cnt = 0;
        // // 구름이 있는지 없는지 체크
        // for(int c=0; c<W; c++){
        //     if(sky[r][c]=='c') cnt++;
        // }

        // // 구름이 아얘 뜨지 않을 경우
        // if(cnt==0){
        //     for(int c=0; c<W; c++){
        //         res[r][c]= -1;
        //     }
        // }
        
        for(int c=W-1; c>=0; c--){
            int move = -1;
            if(sky[r][c]=='.'){ // 구름이 없을 경우
                for(int x=c-1; x>=0; x--){
                    if(sky[r][x]=='c'){
                        move = c-x;
                        break;
                    }
                }
                res[r][c] = move;
            }
            else if(sky[r][c]=='c'){
                res[r][c] = 0;
            }
        }
    }
}
