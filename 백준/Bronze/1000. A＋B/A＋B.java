import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] value = br.readLine().split(" ");
        int N = Integer.parseInt(value[0]);
        int M = Integer.parseInt(value[1]);
        System.out.println(N+M);
        bw.close();
    }
}