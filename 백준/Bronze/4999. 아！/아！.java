import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String a = br.readLine();
            String b = br.readLine();

            if (a.contains(b)) bw.write("go");
            else bw.write("no");
            if (br.readLine() == null) {
                bw.flush();
                return;
            }
        }
    }
}
