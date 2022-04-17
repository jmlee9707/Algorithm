package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11051_2 {
    public static int div = 10007;
    public static int[][] pascal;
    public static void main(String[] args) throws IOException {
        // 이항계수2
        // 파스칼의 삼각형 이용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
    
        // 10007로 나눈 나머지?
    
        pascal = new int[10001][10001]; // 파스칼 삼각형
        
        for(int i=0; i<=n; i++){
             for(int j=0; j<=i; j++){
                  if (i==j || j==0) pascal[i][j]=1; 
                  else pascal[i][j]=(pascal[i-1][j-1]+pascal[i-1][j])%div; 
                } 
            }

        System.out.println(pascal[n][k]);
        
    }
    

}
