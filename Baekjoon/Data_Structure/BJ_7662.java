package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringJoiner;

public class BJ_7662 {
    /*
     * 이중 우선순위 큐
     */
    static int T, k;
    static PriorityQueue<Integer> minheap, maxheap;
    static Map<Integer, Integer> map;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringJoiner sj = new StringJoiner("\n");

        T = Integer.parseInt(br.readLine());
        for(int i=1; i<=T; i++){
            k= Integer.parseInt(br.readLine());
            minheap = new PriorityQueue<>();
            maxheap = new PriorityQueue<>(Collections.reverseOrder());
            map = new HashMap<>();

            for(int j=1; j<=k; j++){
                String[] str = br.readLine().split(" ");
                char action = str[0].charAt(0);
                int num = Integer.parseInt(str[1]);

                if(action=='I'){
                    //insert
                    minheap.add(num);
                    maxheap.add(num);
                    map.put(num, map.getOrDefault(num, 0)+1);
                }
                else if(action =='D'){
                    if(map.isEmpty()) continue;
                    if(num==-1){ // 최솟값
                        delete(minheap);
                    }else if(num==1){
                        delete(maxheap);
                    }
                }
            }
            if(map.isEmpty()){
                sj.add( "EMPTY");
            }else{

                int min = delete(minheap);
                int max = map.isEmpty() ? min : delete(maxheap);
                sj.add(max+" "+min);
            }


        }
        System.out.println(sj.toString());
    }
    public static int delete(PriorityQueue<Integer>pq){

        while(!pq.isEmpty()){
            int num = pq.poll();
            if(map.containsKey(num)){
                if(map.get(num)==1){
                    map.remove(num);
                }else{
                    map.put(num, map.get(num)-1);
                }
                return num;
            }
        }

        return -1;
    }
    
}
