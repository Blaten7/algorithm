import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        factorial(a);
    }
    private static void factorial(int a) throws IOException {
        int result = 1;
        for (int i = 2; i <= a; i++) {
            result *= i;
        }
        System.out.println(result);
    }
}
