package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_19238 {
    /*
     * 백준 19238
     * 스타트 택시
     */
    static public int N, M, oil; // 맵 크기, 승객 수, 초기 연료
    static public int[][] map;
    static public ArrayList<Person> ppl; // 승객 정보
    static public ArrayList<Loca> startList; // 거리 짧은 승객 정보
    static public boolean[][] visited;
    static public int[] dr = { -1, 1, 0, 0 };
    static public int[] dc = { 0, 0, -1, 1 }; // 상하좌우

    public static class Loca implements Comparable<Loca> { // 출발 정보
        int r; // 시작 행
        int c;
        int dis;

        public Loca(int r, int c, int dis) {
            this.r = r;
            this.c = c;
            this.dis = dis;
        }

        @Override
        public int compareTo(Loca l) {
            if (this.dis != l.dis)
                return this.dis - l.dis;
            else {
                if (this.r != l.r)
                    return this.r - l.r;
                else {
                    return this.c - l.c;
                }
            }
        }
    }

    public static class Person {
        int sr; // 시작 행
        int sc;
        int ar; // 도착 행
        int ac;

        public Person(int sr, int sc, int ar, int ac) {
            this.sr = sr;
            this.sc = sc;
            this.ar = ar;
            this.ac = ac;
        }
    }

    static public int[] taxi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        oil = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        ppl = new ArrayList<>();
        startList = new ArrayList<>();
        taxi = new int[2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    map[i][j] = -1; // 승객번호와 헷갈리지 않게 하기 위함 - 벽
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        taxi[0] = Integer.parseInt(st.nextToken()); // 시작 위치
        taxi[1] = Integer.parseInt(st.nextToken()); // 시작 택시 위치

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s_x = Integer.parseInt(st.nextToken());
            int s_y = Integer.parseInt(st.nextToken());
            int a_x = Integer.parseInt(st.nextToken());
            int a_y = Integer.parseInt(st.nextToken());

            ppl.add(new Person(s_x, s_y, a_x, a_y));
            map[s_x][s_y] = i; // 승객 번호를 저쟝
        }

        while (true) {
            if (ppl.size() == 0) { // 모두 데려다 줬을 경우
                break;
            }

            // 태울 승객을 선정해보겠습니당
            startList.clear(); // 초기화!
            choice(taxi[0], taxi[1]);

            if (startList.size() == 0) { // 벽에 막힌 경우
                oil = -1;
                break;
            }

            Loca start = startList.get(0);
            map[start.r][start.c] = 0;
            oil -= start.dis;

            if (oil < 0) { // 오일이 바닥났다면
                oil = -1;
                break;
            }

            // 운전 할 목적지 찾기
            for (int i = 0; i < ppl.size(); i++) {
                Person p = ppl.get(i);
                if (p.sr == start.r && p.sc == start.c) {
                    // 목적지 저장! 운전 시작
                    if (!move(p)) {
                        System.out.println("-1");
                        System.exit(0);
                    } else {
                        ppl.remove(i);
                        break;
                    }
                }
            }
        }
        System.out.println(oil);

    }

    public static void choice(int t_x, int t_y) {
        visited = new boolean[N + 1][N + 1];
        visited[t_x][t_y] = true;

        // 우선순위 큐를 사용해 낮은 거리를 우선으로 빼기
        PriorityQueue<Loca> que = new PriorityQueue<>(); // 최소 힙
        que.add(new Loca(t_x, t_y, 0));

        while (!que.isEmpty()) {
            Loca loca = que.poll();

            if (map[loca.r][loca.c] >= 1) {
                startList.add(new Loca(loca.r, loca.c, loca.dis));
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nr = loca.r + dr[d];
                int nc = loca.c + dc[d];

                if (nr > 0 && nc > 0 && nr <= N && nc <= N && !visited[nr][nc] && map[nr][nc] != -1) {
                    que.add(new Loca(nr, nc, loca.dis + 1));
                    visited[nr][nc] = true;
                }
            }
        }
    };

    public static boolean move(Person p) {

        Queue<Loca> que = new LinkedList<>();
        que.add(new Loca(p.sr, p.sc, 0));
        visited = new boolean[N + 1][N + 1];
        visited[p.sr][p.sc] = true;
        while (!que.isEmpty()) {
            Loca loca = que.poll();

            if (loca.r == p.ar && loca.c == p.ac) {
                int tempOil = loca.dis;
                if (oil - tempOil < 0)
                    return false;

                taxi[0] = p.ar;
                taxi[1] = p.ac;
                oil += tempOil;
                return true;
            }

            for (int d = 0; d < 4; d++) {
                int nr = loca.r + dr[d];
                int nc = loca.c + dc[d];
                if (nr > 0 && nc > 0 && nr <= N && nc <= N && !visited[nr][nc] && map[nr][nc] != -1) {
                    que.add(new Loca(nr, nc, loca.dis + 1));
                    visited[nr][nc] = true;
                }
            }
        }
        return false;
    }
}