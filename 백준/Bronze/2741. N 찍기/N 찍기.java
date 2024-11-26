import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int i = a; int k = 1;
        while (i-- > 0) {
            System.out.println(k);
            k++;
        }
    }
}

