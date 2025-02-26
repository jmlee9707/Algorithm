package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_1043 {
    /*
     * 백준 1043
     * 거짓말
     */
    static int N, M, res;
    static boolean[] trueParty, knownTruth, isVisited;
    static ArrayList<ArrayList<Integer>> party, people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수
        people = new ArrayList<>();
        party = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            people.add(new ArrayList<>()); // 파티 참석 수
        }
        for (int i = 0; i < M; i++) {
            party.add(new ArrayList<>());
        }
        knownTruth = new boolean[N + 1];

        for (int i = 0; i < count; i++) {
            int idx = Integer.parseInt(st.nextToken());
            knownTruth[idx] = true;
        }

        res = M;
        trueParty = new boolean[M]; // 거짓 수

        // party 입력 받기
        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); // 인원수

            for (int j = 0; j < num; j++) {
                int id = Integer.parseInt(st.nextToken());
                people.get(id).add(i); // 파티 정보 저장
                party.get(i).add(id);

                if (knownTruth[id])
                    trueParty[i] = true;

            }

            if (trueParty[i]) {
                for (int idx : party.get(i)) {
                    knownTruth[idx] = true;
                }
            }
        }

        isVisited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (knownTruth[i] && !isVisited[i])
                findTrueMan(i);
        }

        for (int i = 0; i < M; i++) {
            if (trueParty[i])
                res--;
        }

        System.out.println(res);
    }

    public static void findTrueMan(int memID) {
        isVisited[memID] = true;

        for (int id : people.get(memID)) { // member
            trueParty[id] = true;
            for (int temp : party.get(id)) {
                if (!isVisited[temp])
                    findTrueMan(temp);
            }

        }
        return;
    }
}
