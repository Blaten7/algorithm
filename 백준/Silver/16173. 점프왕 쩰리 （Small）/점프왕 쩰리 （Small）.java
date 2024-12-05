/*
Silver4_점프왕쩰리_16173

# 해석 : 점프게임,
        정사각형 구역 내부에서만 움직임 가능
        정사각형 외부로 나갈시 즉시 게임 패배
        출발점은 항상 0, 0 번째 인덱스. 즉 최상단 좌측
        이동은 오른쪽과 아래로만 가능. 제한조건에 유의
        가장 오른쪽, 가장 아래칸. 최하단 우측 도달시 게임 승리
        한번에 이동 가능한 칸 수는. 현재 밟고 있는 칸에 쓰여진 수. 그 이상도 이하도 안됨

        주어진 구역에서 게임을 승리할 수 있는지 없는지 계산
        승리 가능시 HaruHaru 출력
        승리 불가시 Hing 출력

# 입력 :
        Line 1 : 정수 N. N X N 행열로 사용하면 될듯? 다행히 N M 조건은 계산하지 않아도 된다
        Line 2 : 2번째 줄부터 마지막까지 맵 구역의 구성 정수가 주어짐. 테스트 케이스 X

# 로직 : 오른쪽이던 왼쪽이던 뛴다음에 또 뛰고 또 뒤는거까지 계산해서 목적지 갈 수 있는지 없는지 판별 해야 하기 때문에
        재귀 사용해야됨. 근데 재귀 잘 못씀
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] game = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] magma = new boolean[N][N]; // 이미 한번 밟은 땅. 어차피 가봐야 못이김
        magma[0][0] = true;

        boolean found = false;
        for (int i = 0; i < N && !found; i++) {
            for (int j = 0; j < N && !found; j++) {
                if (!magma[i][j] || game[i][j] == 0) { // 전생에 밟았던 곳이거나, 점프력이 0인 구간이면 다음으로~
                    continue;
                }
                int jump = game[i][j];
                if (game[i][j] == -1) { // 목적지. 최하단 우측은 -1 값. 목적지 도착시 승리!
                    found = true;
                    break;
                }
                if (j + jump < N && !magma[i][j + jump]) { // 오른쪽으로 뛰어도 되고? 그 뛴 곳이 전생에 밟았던 곳이 아니라면~
                    magma[i][j + jump] = true;
                }

                if (i + jump < N && !magma[i + jump][j]) {
                    magma[i + jump][j] = true;
                }
            }
        }

        System.out.print(found ? "HaruHaru" : "Hing");
    }
}
