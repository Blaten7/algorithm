import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] input = new int[9][9];
        int maxVal = 0;
        int maxRow = 0, maxCol = 0;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                input[i][j] = Integer.parseInt(st.nextToken());
                if (input[i][j] > maxVal) {
                    maxVal = input[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        bw.write(maxVal + "\n");
        bw.write((maxRow + 1) + " " + (maxCol + 1) + "\n");

        bw.flush();
        bw.close();
    }
}
