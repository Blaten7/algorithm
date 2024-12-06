/*
Silver2_숫자판점프_2210

# 해석 : 고정된 가로세로 5 * 5 크기의 행렬
        각 행렬의 구성은 0 ~ 9 사이의 정수
        임의의 위치에서 시작, 인접한 네 방향으로 다섯번 이동하며
        각 칸의 정수를 차례로 붙이면 6자리의 수가 만들어짐

        이동시 한 번 밟았던 곳을 다시 밟는 것 가능
        최종 6자리수는 0으로 시작도 가능. EX) 000123

        5 * 5 행렬을 입력받아, 만듣 수 있는 6자리수의 개수를 구하시오

# 입력 : 행렬

# 로직 : DFS
 */

import java.io.*;
import java.util.*;

//숫자판 점프
public class Main {
    static int[][] matrix;
    static int[] selected;
    static Set<String> result;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        matrix = new int[5][5];
        selected = new int[6];
        result = new HashSet<>();

        for (int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                int value = Integer.parseInt(st.nextToken());
                matrix[i][j] = value;
            }
        }

        for (int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                dfs(0, i, j);
            }
        }
        bw.write(result.size() + "");
        bw.flush();
    }

    static void dfs(int depth, int r, int c) {
        if(depth==6) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<6; i++) {
                sb.append(selected[i]);
            }
            result.add(sb.toString());
            return;
        }

        for(int d=0; d<4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(isValidPosition(nr, nc)) {
                selected[depth] = matrix[nr][nc];
                dfs(depth+1, nr, nc);
            }
        }
    }

    static boolean isValidPosition(int r, int c) {
        return 0<=r && r<5 && 0<=c && c<5;
    }
}