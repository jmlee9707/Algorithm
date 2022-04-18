package Implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2578 {
    //빙고
    static int N = 25;
    static int cnt, call, res; // 빙고 수, 사회자가 부른 수의 값
    static int[][] board;
    public static void main(String[] args) throws IOException  {
        
        board = new int[5][5]; // 빙고칸 생성 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 빙고판 만들기
        for(int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<5; j++){
                board[i][j] = Integer.parseInt(st.nextToken()); // 값 하나씩 대입하기
            }
        }

        boolean finished = false;
        // 사회자가 값을 부르면 체크하기
        while(call<N){
            // 사회자 값 입력 받기
            for(int i=0; i<5; i++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<5; j++){
                    int num = Integer.parseInt(st.nextToken()); // 사회자가 부르는 값
                    call++;
                    cnt = 0;
                    // 배열에 특정값이 들어있는지 확인
                    numCheck(num);
                    if(cnt>=3 && !finished) {
                        res = call;
                        finished = true;
                    }
                }
            }
        }

        System.out.println(res);
    }

    public static void numCheck(int n){
        
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(board[i][j]==n){
                    board[i][j]=0; // 사회자가 부른 값은 0으로 교환!
                    cnt = lineCheck();
                    return;
                }
            }
        }
    }

    public static int lineCheck(){
        
        int cntB=0;
        // 가로 빙고 확인

        for(int i=0; i<5; i++){
            int rcnt=0;
            for(int j=0; j<5; j++){
                if(board[i][j]==0){
                    rcnt++;
                }
                if(rcnt==5){
                    cntB++;
                    break;
                }
            }
        }

        // 세로 빙고 확인
        
        for(int i=0; i<5; i++){
            int ccnt=0;
            for(int j=0; j<5; j++){
                if(board[j][]==0){
                    ccnt++;
                }
                if(ccnt==5){
                    cntB++;
                    break;
                }
            }
        }
        

        // 내려가는 대각선
        int dcnt = 0;
        for(int i =0; i<5; i++){
            if(board[i][i]==0){
                dcnt++;
            }
            if(dcnt==5){
                cntB++;
                break;
            }
        }

        // 올라가는 대각선
        int ucnt = 0;
        for(int i =0; i<5; i++){
            if(board[4-i][i]==0){
                ucnt++;
            }
            if(ucnt==5){
                cntB++;
                break;
            }
        }

        return cntB;
     
    }
        
}
