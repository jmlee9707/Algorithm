package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2869 {
    //달팽이는 올라가고 싶다
    // 시간 제한 걸려있음 -> 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int day = Integer.parseInt(st.nextToken());
        int night = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        
        int sum = 0;

        int cnt = (length-night) / (day-night);

        if((length-night)%(day-night)!=0){
            cnt++;
        }

        System.out.println(cnt);

        // 시간 초과로 반복문 사용은 X
        // while(true){
        //     sum = a+sum;
        //     if(sum>=v) {
        //         System.out.println(day);
        //         break;
        //     }
        //     sum = sum-b;
        //     day++;
        // }

    }
}
