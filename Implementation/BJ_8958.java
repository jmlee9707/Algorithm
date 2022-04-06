package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_8958{
    static int T, res;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            
            String s = br.readLine();
            int cnt = s.length();

            int tmp = 1;
            for(int i=0; i<cnt; i++){
                if(i==0 && s.charAt(i)=='O'){
                    res = 1; // 1번째 수
                    continue; 
                }
                else if(i==0 &&s.charAt(i)=='X'){
                    res = 0;
                    continue;
                }


                if(s.charAt(i)=='O'){
                    if(s.charAt(i-1)=='X'){
                        tmp = 1;
                        res +=tmp;
                    }
                    else if(s.charAt(i-1)=='O'){
                        tmp++;
                        res +=tmp;
                    }
                }
                else if(s.charAt(i)=='X'){
                    tmp = 0;
                }

            }

            System.out.println(res);
        }
    }
}