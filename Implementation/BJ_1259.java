package Implementation;

import java.util.Scanner;

public class BJ_1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s;
        while(true){
            s = sc.next();
            if(s.equals("0")) {
                break;
            }
            int size = s.length();
            char[] arr = new char[size];

            String ans = "yes";
            for(int i=0; i<size; i++){
                arr[i] = s.charAt(size-1-i);
                if(arr[i]!=s.charAt(i)) {
                    ans = "no";
                    break;
                }
            }

            System.out.println(ans);
        }

    
    }
}
