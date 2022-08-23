package Implementation;

import java.util.Scanner;

public class BJ_1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int n = s.length();
        int arr[] = new int[26]; // 배열에 보관
        for(int i=0; i<n; i++){
            int alpha = (int)(s.charAt(i));
            if(alpha>=97){
                arr[alpha-97]++;
            }
            if(alpha>=65 && alpha<91){
                arr[alpha-65]++;
            }
        }

        int max = 0;
        int res = -1;
        for(int i=0; i<26; i++){
            if(max<=arr[i]) {
                max = arr[i];
                res = i;
            }
        }
        int cnt = 0;
        for(int i=0; i<26; i++){
            if(arr[i]==max) cnt++;
        }

        if(cnt==1){
            System.out.println((char)(res+65));
        }
        else{
            System.out.println("?");
        }

    }
}
