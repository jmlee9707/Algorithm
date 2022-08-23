package Sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

// 나이순 정렬 
public class BJ_10814 {
    
    // public class Member {
    //     String name;
    //     int age;
    //     public Member(String name, int age) {
    //         this.name = name;
    //         this.age = age;
    //     }
    // }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        String [][] member = new String[N][2];  // 배열 만들기

        for(int t=0; t<N; t++){
            st = new StringTokenizer(br.readLine(), " ");
            member[t][0] = st.nextToken();
            member[t][1] = st.nextToken();
        }

        Arrays.sort(member, new Comparator<String[]>() { // 2차원 배열

            @Override
            public int compare(String[] o1, String[] o2) {
               if(o1[0]==o2[0]){
                    return 0; // 나이가 같으면 입력된 순서대로
               }
               else{
                   return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]); // 오름차 순 정렬
               }
            }
            
        });

        for(int i=0; i<N; i++){
            System.out.println(member[i][0]+ " "+ member[i][1]);
        }
    }
}
