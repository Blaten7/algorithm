/*
# 해석 : 그래프위의 특정 정점에서 출발. 목적지까지
        X +- 1 또는 X * 2 위치로 1초마다 이동.

# 입력 :
        Line 1 : 마법소녀의 위치 N과 목적지 위치 K (0 ≤ N, K ≤ 100,000)

# 로직 : 가장 빠른 시간 -> BFS
 */

import java.io.*;
import java.util.*;

//Silver1_숨바꼭질_1697
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static boolean[] visited;
    static int count = 0;

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] T) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) System.out.print(0);
        else {
            Queue<Node> q = new LinkedList<>();
            visited = new boolean[100001];
            visited[N] = true;
            q.add(new Node(N, count));
            while (!q.isEmpty()) {
                Node cur = q.poll();
                if (cur.x == K) {
                    System.out.print(cur.y);
                    break;
                }
                int[] nextX = {cur.x - 1, cur.x + 1, cur.x * 2};
                for (int i = 0; i < nextX.length; i++) {
                    if (nextX[i] >= 0 && nextX[i] <= 100000 && !visited[nextX[i]]) {
                        visited[nextX[i]] = true;
                        q.add(new Node(nextX[i], cur.y + 1));
                    }
                }
            }
        }
    }
}
