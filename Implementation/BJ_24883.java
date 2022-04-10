package Implementation;

import java.util.Scanner;


public class BJ_24883 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String search = sc.nextLine();
        String naver = "Naver D2";
        String other = "Naver Whale";

        if(search.charAt(0)=='N' ||search.charAt(0)=='n'){
            System.out.println(naver);
        }
        else{
            System.out.println(other);
        }
    }
}
