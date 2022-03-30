import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


// MST란?
// 최소 스패닝 트리 
// n개의 점, n개의 점을 서로 하나도 빠짐없이 이을려고 할 때 필요한 최소한의 선의 개수는 ?
// n개의 점을 일렬로 세워보는 것.
// n 개의 점이 주어졌을 때, n*(n-1)/2 = 모든 선의 개수 이 중에서 n -1 개를 고르는 방법 
// 1 - 5 - 3 - 6 - 2 - 4
//        3 
//    4   5  1  6
//        2
// 잇는 비용이 존재 
// 크루스칼 , 프림 
// 크루스칼 
// 크루스칼 3가지 이유
// 1번째, 문제에서 데이터가 애초에 크루스칼에 적합하게 주어진다.
// 2번째, 크루스칼 알고리즘이 더 쉽다.
// 3번째, 어차피 크루스칼과 프림이 하는 일은 똑같다. 
// 모든 간선들 중에 결국 n-1 개를 잘 고르는 방법 -> 크루스칼 알고리즘
// 간선들 중에 n-1를 고를 때 사이클이 없게끔 골라야 한다. 
// n-1개 간선들이 골라졌다면, n-1개 간선의 가중치, 또는 비용의 합이 최소가 되어야 함.

// mst 
// minimum spanning tree -> tree 에는 절대 사이클이 있으면 안된다.
// 1 -> 2 -> 3 -> 1 
// 크루스칼 알고리즘의 순서
// 모든 간선들을 ArrayList<Edge> list 다 넣고 그리고 비용이 적은 순서대로 정렬한다.
// 이제 정렬된 순서대로 간선들을 꺼내서 이 간선을 선택할지 말지 결정한다.

// 선택이 끝나면 선택된 간선들의 비용의 합이 얼마인지 계산한다. 이 때 선택된 간선은 mst임이 보장된다.
public class Solution_3124_이정민 {
    // x번째 점이 속한 그룹의 우두머리를 나타내어주는 배열
    // a,b,c,d번 점이 모두 같은 그룹에 속해있다고 가정.
    // 야 a번아 너가 속한 그룹의 대장이 누구야? 어 그거 d야 
    // 야 b번아 너가 속한 그룹의 대장이 누구야? 그거 d인데?
    // parent[3] == 1;
    // parent[7] == 1;
    // Edge -> start, end 변수 
    // parent[start] == parent[end] 
    public static int[] parent;
    // 8
    // 1,2,3,5,6,7,8,9 번이 속한 그룹 B -> 8  
    // union(A조직의 구성원 중 하나, B조직의 구성원 중 하나)
    // {
        // 너네 A조직 보스 데려와.
        // 너네 B조직 보스 데려와.
        // 둘이 가위바위보 하든 뭐 맞짱을 뜨든 누구 하나가 이제 통합대장해라. 
    // }
    // 1,2,3
    public static void union(int x, int y)
    {
        x = find_parent(x);
        y = find_parent(y);
        if( x != y)
        {
            parent[y] = x;
        }
    }
    // 이 함수는 실질적으로 x가 속한 그룹의 대장 번호를 리턴해라.
    public static int find_parent(int x)
    {
        if(parent[x] == x)
        {
            return x;
        }
        else
        {
            parent[x] = find_parent(parent[x]);
            return parent[x];
        }
    }
    // 간선을 표현해주기 위한 클래스를 하나 만듦.
    public static class Edge implements Comparable<Edge>
    {
        int start; //시작점
        int end; //끝점
        int weight; // 가중치
        Edge(int start, int end, int weight)
        {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge a)
        {
            return this.weight - a.weight;
        }
    }

    public static ArrayList<Edge> list = new ArrayList<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 1; i <= t; i++)
        {
            list.clear(); // 리스트 초기화 
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); // 정점의 개수

            // parent에 1번부터 v번까지의 값이 존재하게끔 
            parent = new int[v+1];
            // 처음 세팅할 때, 1번이 속한 그룹의 대장은 1번
            // 2번 2번
            //3번은 3번
            // 4번은 4번 왜냐 다 아직 혼자 존재하니까. 연결되지 않고.
            for(int k = 1; k<v+1; k++)
            {
                parent[k] = k;
            }
            //만약에 3번 점의 대장을 불러와 하면 어떡하지? 
        // 모든 간선들을 ArrayList<Edge> list 다 넣고 그리고 비용이 적은 순서대로 정렬한다.
        
            int e = Integer.parseInt(st.nextToken()); // 간선의 개수
            for(int j = 0; j < e; j++)
            {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()); 
                int end = Integer.parseInt(st.nextToken()); 
                int weight = Integer.parseInt(st.nextToken());
                list.add(new Edge(start, end, weight)); // 리스트에 추가 
            }
            Collections.sort(list); // 리스트 정렬

        // 이제 정렬된 순서대로 간선들을 꺼내서 이 간선을 선택할지 말지 결정한다.
        // 간선을 꺼내서 내가 만약 이 간선을 선택한다면 싸이클이 발생하는지 아닌지를 따져보자.
        // 발생하면 선택하지 않고, 발생하지 않으면 선택한다.
            long sum = 0; // 가중치 합
          
            for(Edge edge : list)
            {// 비용이 가장 적은 순서대로 꺼냄
                if(find_parent(edge.start) != find_parent(edge.end))
                {
                    // 간선의 시작점과 끝점이 서로 다른 집단에 속해있다면
                    // 그 때는 그 간선을 채택할 때
                    // 채택을 할 때 어떤 작용이 일어나느냐
                    // 서로 다른 두개의 그룹이 하나의 그룹으로 뭉치게 됨. 
                    union(edge.start, edge.end);
                    sum += edge.weight;
                }
            }
            System.out.println("#"+i+" "+sum);
        }
    }
    
}