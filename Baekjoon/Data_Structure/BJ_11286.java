import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_11286 {
        // 절댓값 힙
            
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        class Value implements Comparable<Value>{
            int num;
            int absolute;

            private Value(int num, int absolute){
                this.num = num;
                this.absolute = absolute;
            }
            @Override
            public int compareTo(Value v){
                if(this.absolute != v.absolute) return this.absolute - v.absolute;
                else return this.num - v.num;
            }
        }
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Value> heap = new PriorityQueue<>();
        
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(heap.isEmpty()) System.out.println(0);
                else{
                    Value v = heap.poll();
                    System.out.println(v.num);
                }
            }else{
                heap.add(new Value(x, Math.abs(x)));
            }
        }
    }
}
