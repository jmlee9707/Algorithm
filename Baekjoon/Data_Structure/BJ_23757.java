import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_23757 {

    // 아이들과 선물 상자
    // 우선순위 큐
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            que.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine(), " ");

        int cnt = 0;

        for(int j=0; j<M; j++){
            // 아이가 가지고 싶은 선물 수
            int pre = Integer.parseInt(st.nextToken());
            if(que.peek()>pre){
                int temp = que.poll();
                que.add(temp - pre);
            }else if(que.peek()==pre){
                que.poll();
            }else{
                cnt++;
            }
        }

        System.out.println(cnt!=0 ? 0 : 1);


    }
}
