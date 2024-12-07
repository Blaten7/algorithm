/*
Silver2_알고리즘수업_너비우선탐색_24444

# 해석 : 이전 문제와 같으나 방식만 변경

# 입력 :

# 로직 : 바뀐 자료구조 (스택 -> 큐)에 순서를 반대로 넣어주면 될 듯함
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

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            graph.get(U).add(V);
            graph.get(V).add(U);
        }

        for (List<Integer> adj : graph) {
            Collections.sort(adj);
        }

        ARR = new int[N + 1];
        visited = new boolean[N + 1];

        bfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(ARR[i]);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!visited[node]) {
                visited[node] = true;
                ARR[node] = count++;

                List<Integer> adj = graph.get(node);
                for (int i = 0; i < adj.size(); i++) {
                    if (!visited[adj.get(i)]) {
                        queue.add(adj.get(i));
                    }
                }
            }
        }
    }
}
