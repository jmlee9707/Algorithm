import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_2527 {
    // 백준 2527 직사각형

    static int n;
    static Character res; // 값 출력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = 4;
        for(int t=1; t<=n; t++){

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // 사각형의 값 입력 받기
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());
            

            // 점이 같은 경우
            if((p1==x2)&&(q1 ==y2) || (p1==x2)&&(y1==q2) || (x1==p2) &&(y1 == q2) || (x1 == p2) &&(q1==y2)){
                res = 'c';
            }
            // 공통 부분이 없을 경우
            else if(p2<x1 || p1<x2 || y1>q2 || q1<y2){
                res = 'd';
            }
            // 선분이 겹칠 경우
            else if((q2==y1) || (q1==y2) || (x1==p2) || (p1==x2)){
                res = 'b';
            }
            // 겹치는 부분이 직사각형일 경우
            else{
                res = 'a';
            }

            System.out.println(res);

        }
    }
}
