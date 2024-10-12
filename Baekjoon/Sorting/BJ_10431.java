package Sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_10431 {
    /*
     *백준 10431
     줄세우기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        int step, now, max;
        Queue<Integer> waitList;
        ArrayList<Integer> list;

        for(int i=1; i<=tc; i++){
            st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();
            waitList = new LinkedList<>();
            list = new ArrayList<>();

            for(int j=0; j<20; j++){
                waitList.add(Integer.parseInt(st.nextToken()));// list 더하기
            }
            step = 0;
            list.add(waitList.poll());
            max = list.get(0);
            
            while(!waitList.isEmpty()){
                now = waitList.poll();
                if(max<now){
                    list.add(now);
                    max = now;
                    continue;
                }
                if(list.get(0)>now){
                    step += list.size();
                    list.add(0, now);
                    continue;
                }
                    // 정렬 해야함
                    for(int k = list.size()-1; k>=0; k--){
                        if(list.get(k)<now){
                            step += list.size()-k -1;
                            list.add(k+1, now);
                            break;
                        }
                    
                }
            }

            bw.write(i+" "+step+"\n");
            
        }

        bw.flush();
    }
}
