import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        StringTokenizer st = new StringTokenizer(a, a, true);
        while (st.hasMoreTokens()) {
            String test = st.nextToken();
            if (test.equals(test.toLowerCase())) System.out.print(test.toUpperCase());
            else System.out.print(test.toLowerCase());
        }
    }
}

