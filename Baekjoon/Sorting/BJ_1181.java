package Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BJ_1181 {
    // 단어 정렬
    // 배열 정렬시엔 arrays.sort 메소드에 comparator 구현
    // Arrays.sort에 Comparator 메소드 구현 후 compare 오버라이딩
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        String[] arr = new String[N];

        sc.nextLine(); // 개행 버리기

        for(int i=0; i<N; i++){
            // N개만큼 입력 받음
            arr[i] = sc.nextLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            // 3가지 리턴 값에 의해 위치를 바꿀지 결정
            // 양수 : return o1- o2>0 위치 서로 바꿈 
            // 0 : 
            // 음수 : return o1-o2 <0 위치 안바꿈
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    return o1.compareTo(o2); // 사전 순 정렬
                }
                else{
                    return o1.length() - o2.length(); // 길이 짧은 순에서 긴 순서로
                }
            }
        });

        // 중복제거
        System.out.println(arr[0]);
        for(int i=1; i<N; i++){
            if(!arr[i].equals(arr[i-1])){ // string 객체 같은지 다른지 비교 =
                System.out.println(arr[i]);
            }
        }

    }
}
