
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            if (n == 0) break; // 입력 값이 0이면 종료

            int totalBlocks = n * (n + 1) / 2;
            System.out.println(totalBlocks); // 결과 출력
        }
    }
}
