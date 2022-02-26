import java.util.Scanner;

public class BJ_2477 {
    static int K, res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();

        int maxW = -1;
        int maxH = -1;
        int indexW = -1;
        int indexH = -1;
        int smallH = 0;
        int smallW = 0;

        int [][] temp = new int[6][2];
        for(int i=0; i<6; i++){
            temp[i][0] = sc.nextInt();
            temp[i][1] = sc.nextInt();

            // 가로 한변 길이 찾기 
            if(temp[i][0]==1 || temp[i][0]==2){
                if(temp[i][1]>maxW){
                    maxW = temp[i][1];
                    indexW = i;
                }
            }

            // 세로 한변 길이 찾기 
            if(temp[i][0]==3 || temp[i][0]==4){
                if(temp[i][1]>maxH){
                    maxH = temp[i][1];
                    indexH = i;
                }
            }
        }

        // 큰 밭 크기 구하기
        int big = maxW*maxH;
        // int start = Math.max(indexH, indexW);
        // small = (temp[(start+2)%6][1] * temp[(start+3)%6][1]);

        for(int i=0; i<6; i++){
                // if(temp[indexH][1] == temp[(i+5)%6][1] + temp[(i+1)%6][1]){
                //     smallW = temp[i][1];
                // }
                // else if(temp[indexW][1] == temp[(i+5)%6][1] + temp[(i+1)%6][1]){
                //     smallH = temp[i][1];
                // }

                if((temp[i][0]==1 || temp[i][0]==2)&&temp[indexH][1] == temp[(i+5)%6][1] + temp[(i+1)%6][1]){ //이부분 수정
                    smallW = temp[i][1];
                }
                else if((temp[i][0]==3 || temp[i][0]==4)&&temp[indexW][1] == temp[(i+5)%6][1] + temp[(i+1)%6][1]){ //이부분 수정
                    smallH = temp[i][1];
                }
        }

        int small = smallH * smallW;

        res = (big-small)*K;
        System.out.println(res);

    }
}
