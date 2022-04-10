package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나무조각
public class BJ_2947 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[5];

        // 배열에 숫자 저장
        for(int i=0; i<5; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        change();
    }

    public static void change(){
        while(true){
            for(int i=0; i<4; i++){
                if(arr[i]>arr[i+1]){
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    print();
                }
                else continue;
            }
            if(isComplete()==true) break;
        }

    }

    public static void print(){
        for(int i=0; i<5; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        return;
    }

    public static boolean isComplete(){
        int cnt = 0;
        for(int i=0; i<5; i++){
            if(arr[i]==i+1) cnt++;
        }

        if(cnt==5) return true;
        else return false;
    }
}
