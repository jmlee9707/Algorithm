package Math;

import java.util.Scanner;

//제리와 톰2
public class BJ_17504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        int bottom = arr[N-1];
        int top = 1 +  arr[N-2]*bottom;
        int tmp = 0;
        for(int i=N-3; i>=0; i--){
            tmp = bottom;
            bottom = top; // 분모
            top =  top*arr[i] + tmp;// 분자 
        }

        tmp = top;
        top = bottom;
        bottom = tmp;

        System.out.println((bottom-top)+" "+bottom);

    }
}
