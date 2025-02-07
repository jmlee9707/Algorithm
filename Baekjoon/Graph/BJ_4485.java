package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class BJ_4485 {
    /*
     * 백준 4485
     * 녹색 옷 입은 애가 젤다지?
     */
    static int T, N, rupee;
    static int [][] map;
    static boolean [][] visited;
    static int [] dr= {-1,1,0,0};
    static int [] dc = {0, 0, -1, 1};

    public static class Loca{
        int r;
        int c;
        int cost;

        public Loca(int r, int c, int cost){
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringJoiner sj = new StringJoiner("\n");
        T = 0;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N==0) break;
            T++;
            rupee = 0;
            map = new int[N][N];
            visited = new boolean[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // == input end
            rupee = dijkstra();
            sj.add("Problem "+T+": "+rupee);
            
        }

        System.out.println(sj.toString());
        
    }
    static public int dijkstra(){
        PriorityQueue<Loca> que = new PriorityQueue<>((o1, o2)->o1.cost- o2.cost);
        que.add(new Loca(0,0,map[0][0]));
        visited[0][0] = true;

        while(!que.isEmpty()){
            Loca loca = que.poll();

            if(loca.r==N-1 && loca.c==N-1) return loca.cost;

            for(int d =0; d<4; d++){
                int nr = loca.r + dr[d];
                int nc = loca.c + dc[d];

                if(nr>=0 && nc>=0 && nr<N && nc<N && !visited[nr][nc]){
                    que.add(new Loca(nr, nc, loca.cost+ map[nr][nc]));
                    visited[nr][nc] = true;
                }
            }
        }
        
        return 0;


    }
}
