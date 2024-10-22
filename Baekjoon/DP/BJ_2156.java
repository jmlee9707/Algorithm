package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2156 {
    /*
     * 백준 2156
     * 포도주 시식
     */
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [] graph = new int[N+1];
        int [] dp = new int[N+1];

        for(int i=1; i<=N; i++){
            graph[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        dp[1] = graph[1];

        if(N>1){
            dp[2] = graph[2] + dp[1];
        }
        for(int i=3; i<=N; i++){
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+graph[i], dp[i-3]+graph[i-1]+graph[i]));
        }
        System.out.println(dp[N]);
        
    }
}
