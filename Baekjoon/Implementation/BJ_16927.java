package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_16927 {
    static int [][] arr;
    static int N, M, R, small;
    static int[] dx = {1, 0, -1, 0}; //  하 우 상 좌
    static int[] dy = {0, 1, 0, -1}; // 하 우 상 좌
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M]; // 배열 생성 
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 안에 순환시켜야 할 작은 박스가 몇개인지 구하기 
        // Min(N, M) mod 2 = 0, 작은수는 짝수
        
        small = Math.min(N, M)/2; // 박스의 개수

        // for(int i=0; i<R; i++)
            bing(1, 0, 0, N, M); 
        // }

        print();

    }

    public static void bing(int cycle, int startX, int startY, int finX, int finY){
        
            
        int nr, nc; // 이동할 값 
        int d = 0; // 방향 설정
        int r = startX; // 현재 위치 
        int c = startY; // 현재 위치 
        int tmp1 = arr[r][c]; // 임시 보관 값
        int tmp2 = 0;

        int rowSize = finX - startX; // 가로
        int colSize = finY - startY; // 세로
        // System.out.println("rowSize: "+ rowSize + "colSize : " + colSize);

        int cnt = R % ((rowSize*2)+(colSize*2)- 4); // 한바퀴 통째로 돌지 않도록
        // System.out.println(cnt);

        for(int i=0; i<cnt; i++){
            while(true){ 
                nr = dx[d] + r;
                nc = dy[d] + c;
                
                if(nr>=finX || nr<startX || nc>=finY || nc<startY){
                    d = (d+1)%4;
                    nr = dx[d] + r;
                    nc = dy[d] + c;
                }
            
                tmp2 = arr[nr][nc];
                arr[nr][nc] = tmp1;
                
                r = nr;
                c = nc;
                
                if(r==startX && c ==startY) break; // 다시 시작점으로 돌아오면 종료
                tmp1 = tmp2;
            }
        }    
            
        if(cycle<small) {
            bing(cycle+1, startX+1, startY+1, finX-1, finY-1);
        }
        
    }
        

    public static void print(){
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
        }
    }

}
