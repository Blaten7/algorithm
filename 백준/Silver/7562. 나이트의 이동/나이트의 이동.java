/*
# 해석 : 체스판위의 나이트가 한번에 이동 가능한 칸은 [ X +-2 | +-1 && Y +-1 | +-2 ]
        체스판의 크기와, 나이트의 목적지 좌표가 주어질 때. 이동하는 최소 횟수가 몇번인지 출력하라.

# 입력 :
        Line 1 : 테스트 케이스 [ 각 테스트는 3줄로 구성됨]
        Line T1 : 체스판의 크기
        Line T2 : 나이트의 현재 좌표값
        Line T3 : 나이트의 목표 좌표값

# 로직 : 일단 그래프 문제고. 최소 횟수를 구해야 하기때문에? BFS가 맞는 것 같음.
        이전의 울타리문제에서 상하좌우방향 +-1 씩 이동했던거 응용해서
        8방향 이동좌표값 다 설정하고, 8번돌려서 똑같이 하면 됨

 */

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int testCase, fieldSize, result;
    static int curX, curY, targetX, targetY;
    static int[][] field;
    static boolean[][] visited;
    static int[] commandX = {2, 2, 1, 1, -1, -1, -2, -2};
    static int[] commandY = {1, -1, 2, -2, 2, -2, 1, -1};

    public static void main(String[] x) throws IOException {

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            fieldSize = Integer.parseInt(br.readLine());
            field = new int[fieldSize][fieldSize];
            visited = new boolean[fieldSize][fieldSize];
            st = new StringTokenizer(br.readLine());
            curX = Integer.parseInt(st.nextToken());
            curY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());
            result = bfs(curX, curY);
            System.out.println(result);
        }


    }
    static class Node {
        int x, y, position;
        Node(int x, int y, int position) {
            this.x = x;
            this.y = y;
            this.position = position;
        }
    }

    private static int bfs(int A, int B) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(A, B, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            if (x == targetX && y == targetY) {
                return cur.position;
            }

            for (int i = 0; i < 8; i++) {
                int X = x + commandX[i];
                int Y = y + commandY[i];
                if (X >= 0 && X < fieldSize && Y >= 0 && Y < fieldSize && !visited[X][Y]) {
                    visited[X][Y] = true;
                    q.add(new Node(X, Y, cur.position + 1));
                }
            }
        }
        return -1;
    }
}
