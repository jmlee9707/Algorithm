package Implementation;

import java.util.Scanner;

public class BJ_2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 1;
        for(int i=0; i<3; i++){
            int num = sc.nextInt();
            sum *=num;
        }

        
        int [] arr = new int[10];
        while(sum>=1){
            int save = sum%10;
            arr[save]++; // 사용한 숫자 저장
            sum = sum/10;
        }
        for(int i=0; i<10; i++){
            System.out.println(arr[i]);
        }
        
    }
}
