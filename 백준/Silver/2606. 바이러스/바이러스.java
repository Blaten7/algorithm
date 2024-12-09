/*
# 해석 : 네트워크를 통해 전파되는 웜 바이러스
        연결되어 있기만 하면 다 걸림
        1번 컴퓨터가 바이러스에 걸렸고. 연결정보가 주어질 때,
        1번을 제외한 몇개의 컴퓨터가 바이러스에 걸리는지 개수를 출력하라

# 입력 :
        Line 1   : 컴퓨터 수 C [ 1 ~ 100 ] 1번부터 차례대로
        Line 2   : 간선이 몇개인지 L
        Line 3 ~ : 연결된 번호 쌍

# 로직 : 범위값도 작고, 최단, 최소를 구하는 문제가 아니기때문에 BFS, DFS 둘다 써도 될듯?
        이제는 BFS가 더 익숙해셔져서 BFS로 가는걸로
 */

import java.io.*;
import java.util.*;
//Silver3_바이러스_2606
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static ArrayList<Integer>[] line;
    static boolean[] visited;
    static int count;
    public static void main(String[] x) throws IOException {

        int C = Integer.parseInt(br.readLine());
        int L = Integer.parseInt(br.readLine());

        line = new ArrayList[C+1];
        for (int i = 0; i < C+1; i++) {
            line[i] = new ArrayList<>();
        }
        while (L-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            line[a].add(b);
            line[b].add(a);
        }
        int startPoint = 1;
        visited = new boolean[C+1];
        visited[startPoint] = true;

        bfs(startPoint);

    }

    private static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int k = 0; k < line[cur].size(); k++) {
                int n = line[cur].get(k);
                if (!visited[n]) {
                    visited[n] = true;
                    q.add(n);
                    count++;
                }
            }

        }
        System.out.println(count);
    }
}
