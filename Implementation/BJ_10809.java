package Implementation;

import java.util.Arrays;
import java.util.Scanner;

// 알파벳찾기
public class BJ_10809 {
    public static void main(String[] args) {
        int alpha [] = new int[26];
        Arrays.fill(alpha, -1); // -1로 배열 초기화

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        for(int i=0; i<s.length(); i++){
            int num = s.charAt(i)-97;
            if(alpha[num]==-1){
                alpha[num] = i;
            }
        }

        for(int i=0; i<26; i++){
            System.out.print(alpha[i]+" ");
        }
    }
}
