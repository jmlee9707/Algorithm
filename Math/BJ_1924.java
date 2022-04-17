package Math;

import java.util.Scanner;

// 2007년
public class BJ_1924 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
        String [] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"}; // 0 일요일
    
        int day = 0;
        String res = "";
        if(x==1){
            day = y-1;
            res = days[(day+1)%7];
        }
        else{
            day = 30; // 1월 날짜 더하기
            for(int i=2; i <x; i++){
                day += months[i];
            }
            day+=y;
            res = days[(day+1)%7];
        }
        System.out.println(res);
        
    }

}
