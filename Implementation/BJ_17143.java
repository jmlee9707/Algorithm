package Implementation;
// 낚시왕

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17143 {
    static int[][] sea, after;
    static int R, C, M, res; 
    static Shark[] shark;
    static int [] dx = {0, -1, 1, 0, 0}; // 상하우좌 
    static int [] dy = {0, 0, 0, 1, -1}; // 상하우좌
    
    public static class Shark {
        // int sx;
        // int sy;
        int speed; // 속력
        int dir; // 방향 
        int size; // 크기
    
        public Shark(int speed, int dir, int size) {
            // this.sx = sx;
            // this.sy = sy;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 상어의 수 
        res = 0; // 낚시왕이 잡은 상어 수
        shark = new Shark[10001]; // 상어를 저장할 배열
        sea = new int[R+1][C+1];

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            shark[z] = new Shark(s, d, z); // 상어 크기 인덱스에 저장~
            sea[x][y] = z; // 상어 사이즈 - 번호 대입, 같은 크기를 같는 상어는 없음
        }

        // 낚시왕 이동
        fishing(0);

        System.out.println(res);
    }

    public static void fishing(int fisherman){

        while(fisherman<C){ // C초만큼 진행
            // 상어 다 잡으면 종료
            if(M<0) return;
            
            fisherman++; // 낚시왕 오른쪽 한칸 이동
            //System.out.println(fisherman);

            // 낚시왕이 있는 열에 있는 상어중 땅에서 가장 가까운 물고기 잡기
            for(int i=1; i<=R; i++){
                if(sea[i][fisherman] != 0){
                    res += sea[i][fisherman]; // 상어의 사이즈 냠냠
                    M--;
                   // System.out.println("size: " + sea[i][fisherman] +", res : "+res);
                    sea[i][fisherman] = 0; // 잡아먹었따
                    break;
                }
            }

            after = new int[R+1][C+1]; // 상어 이동 후에 배열

            for(int i=1; i<=R; i++){
                for(int j=1; j<=C; j++){
                    if(sea[i][j]!=0){
                        move(i, j);
                    }
                }
            }
            copy();

        }
    }

    public static void move(int x, int y){ //상어번호
            // 상어 이동
            int idx = sea[x][y]; // 상어 번호
            int size = shark[idx].size; // 상어 사이즈
            int d = shark[idx].dir; // 상어 방향
            
            sea[x][y] = 0;

            // 속력만큼 움직이기 
            for(int i=0; i<shark[idx].speed; i++){    
                int nr = x + dx[d];
                int nc = y + dy[d];

                if(nr>=1 && nr<=R && nc>=1 && nc<=C){
                    x = nr;
                    y = nc;
                }
                else{
                    if(d==4 || d==2){
                        d--;
                    }
                    else if(d==1 || d==3){
                        d++;
                    }
                    nr = x + dx[d];
                    nc = y + dy[d];
                    x = nr;
                    y = nc;
                }
            }

            shark[idx].dir = d; // 방향 갱신
            
            if(after[x][y]>0){
                // 크기가 큰 상어를 after에 저장
                after[x][y] = Math.max(size, after[x][y]);
                M--;
            }
            else{
                after[x][y] = size;
            }
    }

    public static void copy(){
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                sea[i][j] = after[i][j];
            }
        }
    }


}
