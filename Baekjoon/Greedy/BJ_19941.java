package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_19941 {
    /*
     * 백준 19941
     * 햄버거 분배
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char [] arr = br.readLine().toCharArray();
        Queue<Integer> que = new LinkedList<>();
        int res = 0;

        for(int i=0; i<N; i++){
            if(arr[i]=='H') 
                que.add(i);
        }
        boolean[] visited = new boolean[N];


        outer : while(!que.isEmpty()){
            int position = que.poll();
            int start = Math.max(position-K, 0);
            int end = Math.min(N-1, position+K);

            for(int i=start; i<=end; i++){
                if(!visited[i] && arr[i]=='P') {
                    res++;
                    visited[i] = true;
                    arr[i] = 'O';
                    continue outer;
                }
            }
        } 
        System.out.println(res); 

    }
}
