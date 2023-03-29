package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3190 {
    /*
     * 백준 3190
     * 뱀
     */
    static int N, K, L, sec;
    static int[][] map;
    static boolean[][] snake;
    static int[] dr = { 0, 1, 0, -1 }; // 우 하 좌 상
    static int[] dc = { 1, 0, -1, 0 };
    static StringTokenizer st;
    static Queue<Dir> que;
    static Loca head, tail;
    static Deque<Loca> size;

    static public class Loca {
        int x;
        int y;

        public Loca(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static public class Dir {
        int time;
        char direction;

        public Dir(int time, char direction) {
            this.time = time;
            this.direction = direction;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        snake = new boolean[N + 1][N + 1];
        size = new LinkedList<>();
        que = new LinkedList<>();

        for (int i = 0; i < K; i++) { // 사과 배치~
            st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            map[num1][num2] = 1;
        }

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            que.add(new Dir(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
        }

        System.out.println(play());
    }

    public static int play() {
        snake[1][1] = true;
        size.add(new Loca(1, 1));

        int sec = 1; // 1초부터 시작
        int dir = 0;
        Dir target = que.poll();

        while (true) {
            //// 1초 증가
            // 1. 먼저 몸 길이를 늘려 머리를 다음칸에 위치
            int nr = size.getFirst().x + dr[dir];
            int nc = size.getFirst().y + dc[dir];

            if (nr <= 0 || nc <= 0 || nr > N || nc > N || snake[nr][nc])
                return sec; // 게임 종료

            if (map[nr][nc] == 1) { // 2. 사과가 있다면 사과가 없어지고
                size.addFirst(new Loca(nr, nc));
                snake[nr][nc] = true;
                map[nr][nc] = 0;
            } else { // 3. 사과가 없다면 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다
                size.addFirst(new Loca(nr, nc));
                snake[nr][nc] = true;
                snake[size.peekLast().x][size.peekLast().y] = false;
                size.pollLast();
            }

            if (target.time == sec) {
                dir = changeDir(target.direction, dir);
                if (!que.isEmpty())
                    target = que.poll();
            }
            sec++;
        }
    }

    public static int changeDir(char d, int dir) {
        if (d == 'D')
            return (dir + 1) % 4;
        else
            return (dir + 3) % 4;
    }

}