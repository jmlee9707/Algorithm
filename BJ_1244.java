import java.util.Scanner;

public class BJ_1244 {
    static int sn, pn;
    static int[] btn;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sn = sc.nextInt();

        btn = new int[sn+1]; // 1번 스위치부터 시작
        for(int i=1; i<=sn; i++){
            btn[i] = sc.nextInt();
        }

        pn = sc.nextInt();
        for(int i =0; i<pn; i++){
            int gender = sc.nextInt();
            int num = sc.nextInt();

            if(gender==1){
                boy(num);
            }
            else if(gender == 2){
                girl(num);
            }
        }
        // sc.close();

        for(int i =1; i<=sn; i++){
            if(i%20 == 0){
                System.out.println(btn[i]);
            }
            else if(i==sn){
                System.out.print(btn[i]);
            }
            else{
                System.out.print(btn[i]+" ");
            }
        }

    }

    public static void boy(int n){
        for(int i=n; i<=sn; i=i+n){
            if(btn[i]==1) btn[i] = 0;
            else if(btn[i]==0) btn[i] = 1;
        }
    }

    public static void girl(int n){
        // int move = 1;
        int plus = n;
        int minus = n;
        while(true){
            // 좌우대칭이면
            if(btn[plus]==btn[minus]){
                if(plus+1>sn && minus-1<1){
                    break;
                }
                
                plus++;
                minus--;
            }
            // 좌우 대칭이 아니면
            else if(btn[plus]!=btn[minus]){
                plus--;
                minus++;
                break;
            }

            
        }

        for(int i = minus; i<=plus; i++){
            if(btn[i]==1) btn[i] = 0;
            else if(btn[i]==0) btn[i] = 1;
        }
    }
}
