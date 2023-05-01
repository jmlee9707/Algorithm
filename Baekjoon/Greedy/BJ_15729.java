import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_15729 {

    public static int N;
    public static boolean[] ques;
    public static boolean[] answ;

    /*
     * 백준 15729
     * 방탈출
     */

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        answ = new boolean[N]; // 결과 값
        ques = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if (temp == 0)
                answ[i] = false;
            else
                answ[i] = true;
        }

        // 모두 불이 꺼진 상태에서 버튼을 최소로 눌러서 같은 상태
        // 버튼 누르면 오른쪽 두개도 같이 눌림

        // 0 : 꺼짐
        // 1 : 켜짐

        int res = 0;

        for (int i = 0; i < N; i++) {
            if (answ[i] != ques[i] && (i < N - 2)) {
                ques[i] = !ques[i];
                ques[i + 1] = !ques[i + 1];
                ques[i + 2] = !ques[i + 2];
                res++;
                continue;
            }

            if ((i == N - 2) && (answ[i] != ques[i])) {
                ques[i] = !ques[i];
                ques[i + 1] = !ques[i + 1];
                res++;
                continue;
            }
            if ((i == N - 1) && (answ[i] != ques[i])) {
                ques[i] = !ques[i];
                res++;
                break;
            }

        }

        System.out.println(res);

    }
}