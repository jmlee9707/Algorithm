package Math;

import java.util.Scanner;

public class BJ_16463 {
    // 13일의 금요일
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 2019년 1월 1일은 화요일
        int years = 0;
        int month = 0;
        int day = 1; // 0 일요일 1 월 2 화 - 2018년 12월 31일은 월요일
        int isFri = 0; // 13일의 금요일 체크

            // 연수만큼 돌리기
            for(int i=2019; i<=N; i++){
                for(int j=1; j<=12; j++){
                    // 13일이 금요일인지 체크
                    if((day + 13)%7 == 5) isFri++;
                    // 달별로 돌리기
                    day += months[j];
                    if(j==2 && isLeapYear(i)) day++;
                }
            }
        System.out.println(isFri);

    }
    

    public static boolean isLeapYear(int year){
        if(year%400==0) return true;
        else if(year%400!=0 && year%100==0) return false;
        else if(year%100!=0 && year%4==0) return true;
        else return false;
    }
}
