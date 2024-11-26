import java.io.*;
import java.util.StringTokenizer;

public class Main {
    /*
            문제
            재귀 호출만 생각하면 신이 난다! 그렇다면 정신질환을 의심해 볼 수 있습니다.

            첫번째 줄 : a, b, c 중 하나라도 0이하라면 w(a, b, c)를 호출시 1을 리턴
            두번째 줄 : a, b, c 중 하나라도 20을 초과하면 w(a, b, c)를 호출시 w(20, 20, 20)
            세번째 줄 : 위의 조건에 해당하지 않는 경우 w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)

            입력 : 정수 a, b, c가 한 줄에 하나씩 입력됨.
            종료조건 : 셋다 -1값이 입력되면 종료.

            뭐라는건지 모르겠으니까 일단 해보자

            제한 조건 : a, b, c는 -50이상 50이하
         */

    // -50부터 50까지 0을 포함한 101개의 수를 양수로 치환시켜 배열로 저장
    // 0 ~ 101
    private static int[][][] dp = new int[101][101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            bw.write("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        } else if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        if (dp[a + 50][b + 50][c + 50] != 0) { // 0미만의 음수를 양수로 치환시키고자 +50
            return dp[a + 50][b + 50][c + 50];
        }

        if (a < b && b < c) {
            dp[a + 50][b + 50][c + 50] = w(a, b, c - 1)
                    + w(a, b - 1, c - 1)
                    - w(a, b - 1, c);
        } else {
            dp[a + 50][b + 50][c + 50] = w(a - 1, b, c)
                    + w(a - 1, b - 1, c)
                    + w(a - 1, b, c - 1)
                    - w(a - 1, b - 1, c - 1);
        }

        return dp[a + 50][b + 50][c + 50];
    }
}
