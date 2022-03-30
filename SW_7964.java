import java.util.Scanner;

public class SW_7964 {
    // 7964.부먹왕국의 차원 관문
    static int T, N, D; // 테스트 케이스, 도시 수, 이동제한 거리
    static int cnt; // 부먹 왕국이 추가로 건설 해야 하는 차원관문의 최소 개수
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        T = sc.nextInt();
        for(int tc = 1; tc<=T; tc++){
            N = sc.nextInt();
            D = sc.nextInt();
            int[] city = new int[N+2]; // 0번, N+1번 인덱스 존재

            cnt = 0;
            city[0] = 1; // 차원관문 존재 
            city[N+1] = 1; // 차원관문 존재

            for(int i=1; i<=N; i++){
                city[i] = sc.nextInt();
                // if(city[i]==1) cnt++;
            }

            boolean[] visit = new boolean[N+2];

            // 차원관문 건설하기
            int res = door(city, visit);
            System.out.println("#"+tc+" " +res);
        }  
    }
    public static int door(int[] c, boolean[] v){
        cnt = 0; //모든 방문을 마쳤을 떄 리턴

        // 0번 위치 차원 관문으로 갈 수 있는 곳 체크
        v[0] = true; // 0번 위치 방문 
        for(int i=1; i<D; i++){
            v[i] = true;
            cnt++;
        }
        // N+1번 위치 차원 관문으로 갈 수 있는 곳 체크 
        v[N+1] = true; // 0번 위치 방문 
        for(int i=N; i>N-D; i--){
            v[i] = true;
            cnt++;
        }

        for(int i=1; i<=N; i++){
            // 차원 관문이 존재하면, 가능한 거리 모두 체크하고 확인
            if(c[i]==1){
                if(i-D>=0 && i+D<=N+2)


                for(int j = i-D; j<=i+D; j++){
                    if(v[j]==false){
                        v[j] = true;
                        cnt++;
                    }
                }
            }
        }

        int add = 0; // 추가하는 차원관문의 수 

        for(int i=1; i<=N; i++){
            if(cnt==N+2) break;

             if(v[i]==false && c[i]==0){
                c[i] = 1;
                // v[i] = true;
                for(int j = i-D; j<=i+D; j++){
                    if(v[j]==false){
                        v[j] = true;
                        cnt++;
                    }
                }

            }
        }

        return add;
        

    }
}
