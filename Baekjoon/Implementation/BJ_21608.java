package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_21608 {
    /*
     * 백준 21608
     * 상어 초등학교
     */

    public static int N, res;
    public static int[][] student, room;
    public static Queue<Integer> que;
    public static int[] dr = { -1, 0, 0, 1 }; // 상 좌 우 하
    public static int[] dc = { 0, -1, 1, 0 };

    public static class Loca implements Comparable<Loca> {
        public int r;
        public int c;
        public int like;
        public int empty;

        public Loca(int r, int c, int like, int empty) {
            this.r = r;
            this.c = c;
            this.like = like;
            this.empty = empty;
        }

        @Override
        public int compareTo(Loca loca) {
            if (this.like > loca.like) {
                return -1;
            } else if (this.like == loca.like) {
                if (this.empty > loca.empty) {
                    return -1;
                } else if (this.empty == loca.empty) {
                    if (this.r < loca.r)
                        return -1;
                    else if (this.r == loca.r) {
                        if (this.c < loca.c)
                            return -1;
                        else if (this.c == loca.c)
                            return 0;
                        else
                            return 1;
                    } else {
                        return 1;
                    }
                } else
                    return 1;
            } else {
                return 1;
            }

        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        student = new int[(N * N) + 1][4];
        que = new LinkedList<>();

        for (int i = 1; i <= N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int stu = Integer.parseInt(st.nextToken());
            que.add(stu);
            for (int j = 0; j < 4; j++) {
                student[stu][j] = Integer.parseInt(st.nextToken());
            }
        }

        room = new int[N + 1][N + 1];
        res = 0;

        // 학생을 배치하고 room
        position();

        // 만족도 조사
        count();
        System.out.println(res);

    }

    public static void position() {
        // 학생을 배치하기
        room[2][2] = que.poll(); // 제일 처음 학생 배치

        while (!que.isEmpty()) {
            int stu = que.poll(); // 배치
            ArrayList<Loca> list = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {

                    if (room[i][j] != 0)
                        continue;
                    int e = 0; // 비어있는 칸수
                    int l = 0; // 좋아하는 친구가 있는 칸수

                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (nr > 0 && nc > 0 && nr <= N && nc <= N) {
                            if (room[nr][nc] == 0)
                                e++;
                            else if (room[nr][nc] == student[stu][0] || room[nr][nc] == student[stu][1]
                                    || room[nr][nc] == student[stu][2] || room[nr][nc] == student[stu][3]) {
                                l++;
                            }
                        }
                    }

                    list.add(new Loca(i, j, l, e));

                }
            }

            // list 정렬
            Collections.sort(list);
            room[list.get(0).r][list.get(0).c] = stu;
        }
    }

    public static void count() {
        // 만족도 조사하기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int num = room[i][j]; // 앉은 학생의 번호
                int like = 0; // 좋아하는 아이의 수

                for (int d = 0; d < 4; d++) {
                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if (nr > 0 && nc > 0 && nr <= N && nc <= N) {
                        if (student[num][0] == room[nr][nc] || student[num][1] == room[nr][nc]
                                || student[num][2] == room[nr][nc] || student[num][3] == room[nr][nc]) {
                            like++;
                        }
                    }
                }

                switch (like) {
                    case 1:
                        res += 1;
                        break;
                    case 2:
                        res += 10;
                        break;
                    case 3:
                        res += 100;
                        break;
                    case 4:
                        res += 1000;
                        break;
                }

            }
        }
    }
}
