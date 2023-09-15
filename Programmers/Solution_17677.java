package Programmers;

import java.util.*;

public class Solution_17677 {
    /*
     * 프로그래머스
     * 2018 kakao blind recruitment
     * [1차] 뉴스 클러스터링
     */

    static HashMap<String, Integer> map1, map2;
    static Set<String> set;
    static String optional = "[A-Z]";
    static int cnt[] = { 0, 0 };

    public int solution(String str1, String str2) {
        int answer = 0;
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        set = new HashSet<>();

        map1 = makeSet(str1, map1);
        map2 = makeSet(str2, map2);

        checkInter();

        answer = calcSim(cnt[0], cnt[1]);

        return answer;
    }

    public void checkInter() {

        String arr[] = set.toArray(new String[0]);

        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            int cn1 = map1.containsKey(temp) ? map1.get(temp) : 0;
            int cn2 = map2.containsKey(temp) ? map2.get(temp) : 0;

            cnt[0] += Math.min(cn1, cn2);
            cnt[1] += Math.max(cn1, cn2);
        }

        return;

    }

    public HashMap<String, Integer> makeSet(String s, HashMap<String, Integer> map) {

        s = s.toUpperCase(); // 대문자로 교환

        int siz = s.length();

        for (int i = 0; i < siz - 1; i++) {
            String temp = s.substring(i, i + 2);

            if (!temp.matches("^[A-Z]*$")) { // 대문자 문자만 포함되어있는지
                continue;
            }

            if (map.containsKey(temp))
                map.put(temp, map.get(temp) + 1);
            else
                map.put(temp, 1);

            set.add(temp);
        }

        return map;
    }

    public int calcSim(int intersec, int total) {

        double sum;

        if (intersec == 0 && total == 0)
            sum = 1;
        else
            sum = ((double) intersec / (double) total);

        return (int) Math.floor(sum * 65536);

    }
}