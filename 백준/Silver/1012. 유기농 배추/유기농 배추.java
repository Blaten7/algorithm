/*
# 해석 : 행열이 주어지고 1은 배추. 0은 그냥 땅.
        대각선 제외 상하좌우 인접한 덩어리 개수 출력

# 입력 :
        Line 1 : 테스트 케이스 갯수 T
            Line T1   : 가로길이 M(1 ≤ M ≤ 50) 세로길이 N(1 ≤ N ≤ 50) 배추개수 K(1 ≤ K ≤ 2500)
            Line T2 ~ : K개의 줄에 배추의 x, y 좌표값

# 로직 : 행렬이다 신난다. 최소 덩어리 갯수 bfs 렛츠게릿
        아 행렬 아니잖아.. 사기당했어..
 */

import java.io.*;
import java.util.*;
//Silver2_유기농배추_1012
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int width, height, baechu;
    static boolean[][] visited;
    static int[][] farm;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[]T) throws IOException {

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            baechu = Integer.parseInt(st.nextToken());

            farm = new int[width][height];
            visited = new boolean[width][height];
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    farm[i][j] = 0;
                }
            }
            for (int i = 0; i < baechu; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[x][y] = 1;
            }
            int result = 0;
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    if (farm[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }


    }

    private static void bfs(int i, int j) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, j));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;

            for (int k = 0; k < 4; k++) {
                int nextX = curX + dx[k];
                int nextY = curY + dy[k];

                if (nextX >= 0 && nextX < width && nextY >= 0 && nextY < height && farm[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    q.add(new Node(nextX, nextY));
                }
            }
        }
    }

}
