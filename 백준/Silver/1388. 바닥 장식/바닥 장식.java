import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Character[][] A = new Character[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                A[i][j] = line.charAt(j);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j].equals('-') ) {
                    if (j < m - 1 && A[i][j + 1].equals('-')) continue;
                    count++;
                } else if (A[i][j].equals('|') ) {
                    if (i < n - 1 && A[i + 1][j].equals('|')) continue;
                    count++;
                }
            }
        }
        System.out.print(count);
    }
}
