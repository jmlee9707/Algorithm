package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//import com.azul.crs.client.sysinfo.SystemInfoProvider;

public class BJ_1063 {
    static int[][] chess;
    static int N, kingX, kingY, rockX, rockY; 
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1}; // 우, 좌, 하, 상, 우상, 좌상, 우하, 좌하 
    static int[] dy = {0, 0, 1, -1, -1, -1, 1, 1};
  public static void main(String[] args) throws IOException {
      chess = new int[8][8];
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      String king = st.nextToken();
      String rock = st.nextToken();
      N = Integer.parseInt(st.nextToken());

    //   System.out.println(king);
      kingX = king.charAt(0) - 65;
      kingY = 8-(king.charAt(1) - 48);
      rockX = rock.charAt(0) - 65;
      rockY = 8 - (rock.charAt(1) - 48);

    //   System.out.println("kx : " + kingX + ", ky : " + kingY);
    //   System.out.println("rx : " + rockX + ", ry : " + rockY);
      
      for(int i=0; i<N; i++){
        String str = br.readLine().trim();
        // 이동!
        move(str);
      }

    //   kingX = (char)(kingX+65);
    //   rockX = (char)(rockX+65);

      System.out.print((char)(kingX+65));
      System.out.println(8-kingY);
      System.out.print((char)(rockX+65));
      System.out.println(8-rockY);
  } 

  public static void move(String str){
    int d = 0;
    switch(str){
        case "R" : d = 0;
            break;
        case "L" : d = 1;
            break;
        case "B" : d = 2;
            break;
        case "T" : d = 3;
            break;
        case "RT" : d = 4;
            break;
        case "LT" : d = 5;
            break;
        case "RB" : d = 6;
            break;
        case "LB" : d = 7;
            break;
        }
        
    int nrK = dx[d] + kingX;
    int ncK = dy[d] + kingY;
    
    int nrR = rockX;
    int ncR = rockY;

    if(nrK==rockX && ncK==rockY){
        // 돌로 이동할 경우
        nrR = dx[d] + rockX;
        ncR = dy[d] + rockY;
    }
        
    if(nrK>=8 || nrK<0 || ncK>=8 || ncK<0 || nrR>=8 || nrR<0 || ncR>=8 || ncR<0){
        // 범위 넘어서면 무시하기
        return;
    }
    else{
        kingX = nrK;
        kingY = ncK;
        rockX = nrR;
        rockY = ncR;
        return;
    }
  }
}
