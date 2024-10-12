package Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BJ_25757 {
    
    /*
     * 백준 25757
     *  임스와 함께하는 미니게임
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s.split(" ")[0]);
        String game = s.split(" ")[1];
        int members = 0;
        if(game.equals("Y")) members = 1;
        else if(game.equals("F")) members = 2;
        else members = 3;

        HashSet<String> map = new HashSet<>();
        for(int i=0; i<n; i++){
            map.add(br.readLine());
        }

        System.out.println(map.size()/members);
        
    
    }
}
