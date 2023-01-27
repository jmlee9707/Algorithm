package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Loca {
    int x;
    int y;

    public Loca(int x, int y) { // 생성자 함수
        this.x = x;
        this.y = y;
    }
}

public class BJ_15686 {
    /*
     * 백준 15686
     * 치킨 거리
     */
    static int[][] city;
    static int N, M, min;
    static ArrayList<Loca> house;
    static ArrayList<Loca> chicken;
    static boolean[] combi;

    public static void main(String[] args) throws IOException {
        // 치킨 거리는 집과 가장 가까운 치킨집 사이의 거리
        // 각각의 집은 치킨 거리를 가지며
        // 도시의 치킨 거리는 모든 집의 치킨 거리의 합
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        min = Integer.MAX_VALUE;
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 2)
                    chicken.add(new Loca(i, j)); // 좌표값 저장
                else if (city[i][j] == 1)
                    house.add(new Loca(i, j)); // 좌표값 저장
            }
        }
        // chiCnt 중에서 M개를 선택하여 도시의 치킨 거리 최솟값을 구해야한다.
        // 1. chiCnt 중에서 M개를 선택, 조합
        // 2. 집의 개수만큼 dfs 탐색! -> 최단 거리 탐색이기 때문

        combi = new boolean[chicken.size()]; // 조합을 위한 boolean 배열
        dfs(0, 0);

        // 결과 출력
        System.out.println(min);
    }

    public static void dfs(int cnt, int start) {
        if (M == cnt) {
            // 집의 개수만큼 dfs 탐색
            int sum = 0; // 도시의 치킨 거리
            for (int j = 0; j < house.size(); j++) {
                // 집과 선택된 치킨집간의 모든 거리를 비교
                int temp = Integer.MAX_VALUE;
                for (int k = 0; k < chicken.size(); k++) {
                    if (combi[k]) {
                        // 선택된 치킨집이라면
                        int d = Math.abs(chicken.get(k).x - house.get(j).x)
                                + Math.abs(chicken.get(k).y - house.get(j).y);

                        temp = Math.min(temp, d);
                    }
                }
                sum += temp;
            }
            min = Math.min(sum, min);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if (!combi[i]) {
                combi[i] = true;
                dfs(cnt + 1, i + 1);
                combi[i] = false;
            }
        }

    }
}
