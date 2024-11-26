import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = 5;
        int k = 0;
        while (test-- >0) {
            int a = Integer.parseInt(br.readLine());
            k += a;
        }
        System.out.println(k);
    }
}
