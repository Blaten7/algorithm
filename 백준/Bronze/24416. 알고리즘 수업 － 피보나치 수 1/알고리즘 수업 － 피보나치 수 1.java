import java.io.*;
public class Main {

    public static int code2RunCount = 0;

    public static void main(String[] args) throws IOException {

        /*
            문제
            첫 번째 줄에 5이상 40이하의 n이 주어짐

            코드1 : n이 1또는 2이면 1반환, 아니면 재귀(n-1) + 재귀(n-2)

            코드2 : 피보나치 수열 계산 로직

        */
        //

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        code2(n);
        bw.write(code1(n) + " " + code2RunCount);
        bw.flush();
        bw.close();
    }
    public static int code1(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return code1(n - 1) + code1(n - 2);
        }
    }
    public static void code2(int n) {
        if (n <= 2) {
            return;
        }
        int[] f = new int[n + 1];
        f[1] = 1;
        f[2] = 1;
        for (int i = 3; i <= n; i++) {
            code2RunCount++;
            f[i] = f[i - 1] + f[i - 2];
        }
    }
}