package BF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14889 {
    /*
     * 백준 14889
     * 스타트와 링크
     */
    static int N, min, member;
    static int[][] stats;
    static int[] startTeam;
    static int[] linkTeam;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        stats = new int[N][N]; // 능력치 저장
        member = N / 2;
        startTeam = new int[member];
        linkTeam = new int[member];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi(0, 0);

        // 입력 끝!
        System.out.println(min);
    }

    public static void combi(int start, int cnt) {
        if (cnt == member) {
            // 다 뽑았다면
            int temp = 0;
            boolean[] num = new boolean[N];
            for (int i = 0; i < startTeam.length; i++) {
                num[startTeam[i]] = true;
            }
            for (int i = 0; i < N; i++) {
                if (!num[i]) {
                    linkTeam[temp] = i;
                    temp++;
                }
            }
            sumStats();
            return;
        }
        for (int i = start; i < N; i++) {
            startTeam[cnt] = i;
            combi(i + 1, cnt + 1);
        }
    }

    public static void sumStats() {
        int startSum = 0;
        int linkSum = 0;

        for (int i = 0; i < startTeam.length - 1; i++) {
            for (int j = i + 1; j < startTeam.length; j++) {
                startSum += stats[startTeam[i]][startTeam[j]] + stats[startTeam[j]][startTeam[i]];
                linkSum += stats[linkTeam[i]][linkTeam[j]] + stats[linkTeam[j]][linkTeam[i]];
            }
        }

        min = Math.min(Math.abs(startSum - linkSum), min);
        return;

    }
}
