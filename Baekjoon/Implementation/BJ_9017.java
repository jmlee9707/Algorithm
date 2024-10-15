package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_9017 {
    /*
     * 백준 9017
     * 크로스컨트리
     */
    static int tc, N;
    static HashMap<Integer, Integer> map;
    static ArrayList<Integer> arr;
    static HashMap<Integer, Team> info;

    static public class Team {
        int idx;
        int count;
        int score;
        int fifth;

        public Team(int idx, int count, int score, int fifth) {
            this.idx = idx;
            this.count = count;
            this.score = score;
            this.fifth = fifth;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            map = new HashMap<>();
            arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int temp = Integer.parseInt(st.nextToken());
                arr.add(temp); // 순서 보장 위해
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }

            // 6명 안되는 팀 제외
            info = new HashMap<>();
            for (int id : map.keySet()) {
                int cnt = map.get(id);
                if (cnt < 6)
                    continue;
                else
                    info.put(id, new Team(id, 0, 0, 0));
            }
            int rank = 1;
            for (int i = 0; i < arr.size(); i++) {
                int num = arr.get(i);
                if (!info.containsKey(num))
                    continue;

                // 만약 있다면
                Team team = info.get(num);
                team.count++;
                if (team.count < 5)
                    team.score += rank;
                if (team.count == 5)
                    team.fifth = rank;

                info.put(num, team);
                rank++;
            }

            // info 중에서 정렬
            // 1. score 가 낮은 순 -> fifth 가 작은 순
            List<Team> sortedTeam = new ArrayList<>(info.values());
            Collections.sort(sortedTeam, new Comparator<Team>() {
                @Override
                public int compare(Team t1, Team t2) {
                    if (t1.score != t2.score) {
                        return t1.score - t2.score;
                    }
                    return t1.fifth - t2.fifth;
                }
            });
            System.out.println(sortedTeam.get(0).idx);
        }

        System.out.println(sb);
    }

}
