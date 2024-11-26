import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
            예제를 보고 규칙을 유추. * 출력

            2 : 가로 다섯개 세로 다섯개, 빈공간 2개 있는 사각형.
            3 : 가로 9개, 세로 9개. 화면상의 빈공간은 생각X
            이전의 사각형을 포함할 수 있는 사각형.
            1 은 그냥 *인데 2부터 가로세로 길이 +4. 에 이전거 다 포함

            첫 번째 줄에 1이상 100이하의 수가 주어짐
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int whatIsNumber = Integer.parseInt(br.readLine());

        int printCount = 1 + (whatIsNumber - 1) * 4;

        for (int i = 0; i < printCount; i++) { // 행
            for (int j = 0; j < printCount; j++) { // 열
                int k = Math.min(Math.min(i, j), Math.min(printCount - 1 - i, printCount - 1 - j));
                if (k % 2 == 0) {
                    bw.write("*");
                } else {
                    bw.write(" ");
                }
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}