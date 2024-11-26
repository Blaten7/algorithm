import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] A = new int[a][b];
        int[][] B = new int[a][b];
        int[][] result = new int[a][b];

        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < b; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < a; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < b; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                bw.write(result[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
