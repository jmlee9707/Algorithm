import java.util.Scanner;
// 수열 백준 2491번

public class BJ_2491 {
    static int N, cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] arr = new int [N];

        for(int i = 0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        int max = 1;
        cnt = 1;

        for(int i=0; i<N-1; i++){
            if(arr[i]<=arr[i+1]){
                cnt++;
            }
            else {
                cnt = 1;
            }

            if(cnt>=max){
                max = cnt;
            }
            
        }

        cnt = 1;
        for(int i=0; i<N-1; i++){
            
            if(arr[i]>=arr[i+1]){
                cnt++;
            }
            else {
                cnt = 1;
            }

            if(cnt>=max){
                max = cnt;
            }

        }

        System.out.println(max);

    }
}
