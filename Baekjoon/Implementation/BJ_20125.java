package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_20125 {
    static int N;
    static char [][] map;
    static int [] heart = {-1, -1};
    static int [] dr = {1, 0, 0}; // 하좌우
    static int [] dc = {0, -1, 1};
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        int [] heart = {-1, -1};
        int [] len = new int[5]; // left arm, right, waist, left leg, right leg

        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
            
            if(heart[0] == -1){
                for(int j=0; j<N; j++){
                    if(map[i][j]=='*') {
                        heart[0] = i+1;
                        heart[1] = j;
                   }
                }
            }
            
        }
        len[0] = calcLeng(heart[0], heart[1]-1, 1);
        len[1] = calcLeng(heart[0], heart[1]+1, 2);
        len[2] = calcLeng(heart[0]+1, heart[1], 0);
        int waist = len[2];
        len[3] = calcLeng(heart[0]+waist+1, heart[1]-1, 0);
        len[4] = calcLeng(heart[0]+waist+1, heart[1]+1, 0);

        System.out.println(heart[0]+1+" "+(heart[1]+1));
        System.out.println(len[0]+" "+len[1]+" "+len[2]+" "+len[3]+" "+len[4]);
    }
    static public int calcLeng(int sr, int sc, int dir){
        int size = 1;
        int r = sr;
        int c = sc;
        while(true){
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if(nr<0 || nc<0 || nr>=N || nc>=N || map[nr][nc]=='_'){
                break;
            }
            r  = nr;
            c = nc;
            size++;
        }
        return size;
    }
}
