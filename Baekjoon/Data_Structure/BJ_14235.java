import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_14235 {

    // 크리스마스 선물
    // 우선 순위 큐
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int a;
        int n = Integer.parseInt(br.readLine()); // 아이들과 거점 방문 횟수

        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            if(a==0){
                // 아이들을 만남
                System.out.println(que.isEmpty() ? "-1" : que.poll());
            }else{
                for(int j=1; j<=a; j++){
                    que.add(Integer.parseInt(st.nextToken()));
                }
            }
        }


    }
}