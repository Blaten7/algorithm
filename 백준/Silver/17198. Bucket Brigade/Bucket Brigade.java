/*
# 해석 : 10 * 10 크기의 농장에 화재발생.
        B -> 불이 난 헛간
        R -> 호수
        L -> 바위
        소들은 호수와 헛간 사이의 길을 따라 자리르 잡고, 물통을 통과시켜 화재를 진압하고자 함.
        양동이는 동서남북으로 인접해 있는 소들 사이로 이동 가능.
        소는 호수에 바로 인접해 있어야만 물을 길수 있음.
        소는 헛간에 바로 인접해 있어야만 물을 헛간에 뿌려 불을 끌 수 있음.
        헛간의 불을 끄기 위해 필요한 소의 최소 마릿수를 구해야 함.
        바위가 있으면 소는 못가고, 헛간과 호수는 바로 인접해 있지 않음.

# 입력 :  헛간 1개, 호수 1개, 바위1개 외 빈지형 으로 구성된 10 * 10 크기의 농장 구성이 주어짐
        Line 1 :
        Line 2 :
        Line 3 :

# 로직 : 아아 B가 헛간, R이 바위, L이 호수구나 이것때문에 아무 의미없이 시간날림
        그냥 울타리문제하고 똑같이 풀면 될듯?
 */

import java.io.*;
import java.util.*;

//Silver4_BucketBrigade_17198
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] moveX = {1, -1, 0, 0};
    static int[] moveY = {0, 0, 1, -1};
    static boolean[][] visited;
    static char[][] farm;
    static int count;
    static int BX, BY, LX, LY;

    static class Node {
        int x, y, atLeast;

        Node(int x, int y, int atLeast) {
            this.x = x;
            this.y = y;
            this.atLeast = atLeast;
        }
    }

    public static void main(String[] x) throws IOException {
        farm = new char[10][10];
        for (int i = 0; i < 10; i++) {
            String line = br.readLine();
            for (int j = 0; j < 10; j++) {
                farm[i][j] = line.charAt(j);
                if (farm[i][j] == 'B') {
                    BX = i;
                    BY = j;
                } else if (farm[i][j] == 'L') {
                    LX = i;
                    LY = j;
                }
            }
        }
        visited = new boolean[10][10];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(BX, BY, 0));
        visited[BX][BY] = true;
        count = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int curX = cur.x;
            int curY = cur.y;
            if (curX == LX && curY == LY) {
                System.out.print(cur.atLeast - 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newX = curX + moveX[i];
                int newY = curY + moveY[i];
                if (newX >= 0 && newX < 10 && newY >= 0 && newY < 10 && !visited[newX][newY] && farm[newX][newY] != 'R') {
                    visited[curX][curY] = true;
                    q.add(new Node(newX, newY, cur.atLeast + 1));
                }
            }
        }
        System.out.print(-1);
    }
}
