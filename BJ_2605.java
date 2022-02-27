import java.util.LinkedList;
import java.util.Scanner;

public class BJ_2605 {
    static int N;
    static LinkedList<Integer> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();

        list = new LinkedList<>();

        int idx = 0;
        for(int i = 0; i<N; i++){
            int num = sc.nextInt(); // 뽑은 번호
            int student = i+1;
            idx = i-num; // 리스트 접근 인덱스

            // if(num!=0){
            //     for(int j=i-1; j>=idx+1; j--){
            //         int temp = list.get(j);
            //         list.add(j+1, temp);
            //     }
            //     list.add(idx, student); // 순서 삽입
            // }
            // else{
            //     list.add(idx, student);
            // }

            list.add(idx, student);
        }

        for(int i=0; i<N-1; i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.print(list.get(N-1));
        


    }
}
