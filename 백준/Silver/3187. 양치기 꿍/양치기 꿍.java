/*
Silver1_양치기꿍_3187

# 해석 : 같은 울타리 안의 영역만 탐색
        양이 늑대보다 많으면 늑대가 죽고, 늑대가 양과 같거나 많으면 양이 디짐
        빈공간 => '.' , 늑대 => 'v' , 양 => 'k'
        살아남은 양 + " " + 늑대 수를 출력하라

# 입력 :
        Line 1 : 영역의 세로 R 과 가로 C 가 주어짐. R, C (3 ≤ R, C ≤ 250)

        Line 2 : R 개의 줄에 C개의 문자가 주어짐.

# 로직 :
 */

import java.io.*;
import java.util.*;

public class Main {
    static int R;
    static int C;
    static char[][] farm; // = new int[R][C][카]
    static int notDeadSheep, notDeadWolf;
    static int[] disX = {0, 0, 1, -1};
    static int[] disY = {1, -1, 0, 0};
    static boolean[][] visited;

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        farm = new char[R][C];
        visited = new boolean[R][C];

        // 농장, 울타리, 늑대, 양을 3D 프린터로 출력
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                farm[i][j] = line.charAt(j);
            }
        }

        // 정찰 시작
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (farm[i][j] != '#' && !visited[i][j]) {
                    DFS(i, j);
                }
            }
        }
        System.out.print(notDeadSheep + " " + notDeadWolf);

    }

    private static void DFS(int x, int y) {
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(x, y));
        visited[x][y] = true;

        int sheepCount = 0;
        int wolfCount = 0;

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            switch (farm[node.x][node.y]) {
                case 'k':
                    sheepCount++;
                    break;
                case 'v':
                    wolfCount++;
                    break;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = node.x + disX[i];
                int nextY = node.y + disY[i];

                if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && !visited[nextX][nextY] && farm[nextX][nextY] != '#') {
                    visited[nextX][nextY] = true;
                    stack.push(new Node(nextX, nextY));

                }
            }
        }
        if (wolfCount < sheepCount) {
            notDeadSheep += sheepCount;
        } else {
            notDeadWolf += wolfCount;
        }

    }
}
