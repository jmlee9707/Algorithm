import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_20665 {
    static int N, T, P, res; // 좌석 갯수, 독서실 예약자 수, 좋아하는 좌석 번호, 결과값
    static Time[] time;
    static int first, last;
    static boolean[][] isSeat;

    static class Time implements Comparable<Time> {
        int startT;
        int endT;

        public Time(int startT, int endT) {
            this.startT = startT;
            this.endT = endT;
        }

        public int compareTo(Time t) {
            if (t.startT == startT) {
                return endT - t.endT;
            } else
                return startT - t.startT;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        time = new Time[T];
        first = hourToMin(900); // 0
        last = hourToMin(2100); // 720
        isSeat = new boolean[last - first + 1][N + 1];

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            time[i] = new Time(hourToMin(start), hourToMin(end));
        }

        Arrays.sort(time); // 예약은 먼저 온 순번대로

        // 남은 자리 체크 후 배정
        for (int i = 0; i < T; i++) {
            Time cur = time[i]; // 확인할 사람
            int s = cur.startT;
            int e = cur.endT;

            int seat = findSeat(s); // 앉을 자리 배정
            if (seat == 0)
                seat = 1;
            for (int j = s; j < e; j++) {
                isSeat[j][seat] = true;
            }

        }
        res = 0;
        for (int i = first; i < last; i++) { // 좋아하는 자리가 비엇는가?
            if (!isSeat[i][P])
                res++;
        }

        System.out.println(res);

    }

    public static int hourToMin(int t) {
        // 시간
        int hour = (t / 100 - 9) * 60;
        int min = t % 100;
        return hour + min;
    }

    public static int findSeat(int t) {
        int seat = 0;
        int maxD = 0;
        // 현재 시간에 사람들과 가장 멀리 떨어진 자리는?
        for (int i = 1; i <= N; i++) {
            if (!isSeat[t][i]) {
                // 가장 멀리 떨어진 거리 값 구하기
                int d = calcFarDis(t, i);
                if (maxD < d) {
                    maxD = d;
                    seat = i;
                }
            }
        }
        return seat;
    }

    public static int calcFarDis(int t, int seat) { // 가장 가까이 앉은 거리가 얼마인지 구하기
        int minD = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            if (i == seat)
                continue;
            if (isSeat[t][i]) {
                int temp = Math.abs(seat - i);
                minD = Math.min(minD, temp);
            }
        }

        return minD;
    }
}
