
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null && !line.trim().equals("0 0")) { // Add stop condition
            StringTokenizer st = new StringTokenizer(line);

            // Parse inputs N and S
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            // Calculate the maximum value of x
            int x = S / (N + 1);

            // Output the result
            System.out.println(x);
        }
    }
}
