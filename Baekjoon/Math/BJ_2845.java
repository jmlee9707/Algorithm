package Math;
import java.util.Scanner;

public class BJ_2845{
    // 파티가 끝나고 난 뒤
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int p = sc.nextInt();

        int res = l*p;

        for(int i=0; i<5; i++){
            int a = sc.nextInt();
            System.out.print(a-res+" ");
        }
    }
}