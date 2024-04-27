package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BJ_1972 {

    // 놀라운 문자열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isSurprising = true;
        Set<String> set;

        while(true){
            String s = br.readLine();
            if(s.equals("*")) break;
            
            isSurprising = true;

            int size = s.length();
            outer : for(int i=1; i<size-1; i++){ // 거리 쌍
                set = new HashSet<>();
                for(int j = 0; j<size-1; j++){
                    if(j+i>=size) continue;
                    String sub = String.valueOf(s.charAt(j)) + String.valueOf(s.charAt(j+i));
                    
                    if(set.contains(sub)){
                        isSurprising = false;
                        break outer;
                    }else{
                        set.add(sub);
                    }
                }
            }


            if(isSurprising) System.out.println(s+" is surprising.");
            else System.out.println(s +" is NOT surprising.");

        }
    }
}
