import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] value = br.readLine().split(" ");
        int x = Integer.parseInt(value[0]);
        int y = Integer.parseInt(value[1]);
        int w = Integer.parseInt(value[2]);
        int h = Integer.parseInt(value[3]);


        int result = Math.min(Math.min(x, w - x), Math.min(y, h - y));
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}