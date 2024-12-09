/*
# 해석 : 1 ~ N 개의 도시와 M개의 단방향 도로가 존재. 모든 도로의 거리 1
        특정한 도시 X에서 출발, 도달 가능한 도시중에 최단거리가 정확하게 K인 모든 도시의 번호를 출력하라.

        출발도시 X에서 출발도시 X로 가는 최단거리는 0.
        또한, 실제로 이동한 선의 개수와 관계없이 목적지까지의 최단거리가 K임에 유의.

# 입력 :
        Line 1   : 도시의 개수 N, 도로의 개수 M, 거리정보 K, 출발도시 번호 X (2 ≤ N ≤ 300,000, 1 ≤ M ≤ 1,000,000, 1 ≤ K ≤ 300,000, 1 ≤ X ≤ N)

        Line 2 ~ : M개의 줄에 도로 정보가 입력됨. A B => A에서 B로 이동하는 단방향 도로 (1 ≤ A, B ≤ N) 단, A와 B는 서로 다른 자연수

# 출력 : 출발지 X에서 도달 가능한 도시중에 최단거리가 K인 모든 도시의 번호를. 한 줄에 하났<ㅣ>오름 차순으로 출력.
        도달 가능한 도시중에서 최단거리가 K인ㄷ 도시가 하나도 ㅇ벗으면 -1

# 로직 : 이것ㄷ ㅗ 최단경로니까 BFS.
 */

import java.io.*;
import java.util.*;

//Silver2_특정거리의도시찾기_18352
public class Main {
//        static class Node {
//        int x, y;
//        Node(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, K, X;
    static ArrayList<Integer>[] arr;
    static int[] target;
    static boolean[] visited;

    public static void main(String[] x) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }
        target = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            target[i] = -1;
        }
        target[X] = 0;
        visited = new boolean[N + 1];
        visited[X] = true;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[A].add(B);
        }
        bfs(X);
    }

    private static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < arr[cur].size(); i++) {
                int key = arr[cur].get(i);
                if (!visited[key]) {
                    target[key] = target[cur] + 1;
                    visited[key] = true;
                    q.add(key);
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (target[i] == K) {
                result.add(i);
            }
        }
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for (int city : result) {
                System.out.println(city);
            }
        }

    }
}
