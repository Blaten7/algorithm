import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int i = 0;
        while (i++ < 9) {
            System.out.println(a+" * "+i+" = "+a*i);
        }
    }
}
