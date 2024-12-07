/*
Silver2_알고리즘수업.깊이우선탐색1_24479

# 해석 : 1 ~ N개의 정점과 M개의 가중치가 1인 간선으로 구성된 무방향 그래프
        정점 R에서 시작하여 깊이 우선 탐색의 경우 노드 방문순서 출력
        인접 정점은 오름차순으로 방문

# 입력 :
        Line 1 : 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)

        Line 2 : 정점 U와 정점 V의 가중치 1인 양방향 간선 (1 ≤ u < v ≤ N, u ≠ v) 모든 간선의 (u, v) 쌍의 값은 서로 다름

        출력 : N개의 줄에 방문 노드를 한 개씩 출력.
        시작정점의 방문 순서는 1, 시작 정점에서 방문이 불가한 경우 0

# 로직 : 이제 갓 따끈따끈하게 DFS에 대해서 이해했는데 갑자기 이상한거 나옴.
        무조건 1로 시작해서, 1과 연결된 간선중 최소치 값을 방문하고, 방문처리
        그 방문된 곳에서 또 최소치값 방문, 방문처리.
        방문할때마다 방문한 곳의 번호를 찍고?
        연결되어있지 않은 정점은 0으로 출력

# 이슈 : 처음 이해서 행렬로 이해해서 그런지 행렬이 익숙함
        근데 행렬쓰니까 메모리 터짐, 익숙한게 이거라 그냥 써본건데
        사실 값 범위가 효율적으로 하세요~ 말하고 있었으니까..
        그러면은.,. 세션때 들었던 [ [], [] ] 형태로 가야 될 것 같기는 함.

 */

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static int[] ARR;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            graph.get(U).add(V);
            graph.get(V).add(U);
        }

        // 인접 리스트 정렬
        for (List<Integer> adj : graph) {
            Collections.sort(adj);
        }

        // 방문 순서 기록용 배열
        ARR = new int[N + 1];
        visited = new boolean[N + 1];

        // DFS 실행
        dfs(R);

        // 결과 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(ARR[i]);
        }
    }

    static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;
                ARR[node] = count++;

                // 인접 노드 스택에 추가 (역순으로 방문)
                List<Integer> adj = graph.get(node);
                for (int i = adj.size() - 1; i >= 0; i--) {
                    if (!visited[adj.get(i)]) {
                        stack.push(adj.get(i));
                    }
                }
            }
        }
    }
}
