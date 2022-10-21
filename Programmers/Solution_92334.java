package Programmers;

import java.util.HashMap;

public class Solution_92334 {

    // 프로그래머스
    // 신고결과 받기
    public static void main(String[] args) {
        String[] id_list = { "muzi", "frodo", "apeach", "neo" };
        String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
        int k = 2;
        Solution1 sol = new Solution1();
        int[] res = sol.solution(id_list, report, k);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}

class Solution1 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        boolean[][] notice = new boolean[id_list.length][id_list.length]; // 신고 횟수 체크
        int[] count = new int[id_list.length];

        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> cnt = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], i);
        }

        for (int i = 0; i < report.length; i++) {
            String[] temp = report[i].split(" ");
            // map 값 가져오기
            int reporterNum = map.get(temp[0]);
            int victimNum = map.get(temp[1]);

            if (!notice[reporterNum][victimNum]) {
                // 아직 신고하지 않았다면
                notice[reporterNum][victimNum] = true;
                if (cnt.containsKey(temp[1])) { // 이미 신고를 1번 이상 받았다면
                    cnt.put(temp[1], cnt.get(temp[1]) + 1);
                } else { // 신고를 아직 안받았다면
                    cnt.put(temp[1], 1);
                }
            }
        }

        // 신고 마지막으로 신고 횟수 일괄 확인
        // for(int start=0; start<id_list.length;i++){
        // int num = 0;
        // for(int j=0; j<id_list.length;j++){
        // if(notice[j][start]) {
        // num++;
        // }
        // }
        // if(num>=k){
        // for(int j=0; j<id_list.length; j++){
        // if(notice[j][start]) count[j]++;
        // }
        // }
        // }

        for (int i = 0; i < id_list.length; i++) {
            if (cnt.containsKey(id_list[i]) && cnt.get(id_list[i]) >= k) {
                // 신고한 사람에게 메일 보내기
                for (int j = 0; j < id_list.length; j++) {
                    if (notice[j][i])
                        count[j]++;
                }
            }
        }

        answer = new int[id_list.length];
        answer = count.clone();

        return answer;
    }
}
