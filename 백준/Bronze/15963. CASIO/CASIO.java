import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        if (sc.nextBigInteger().equals(sc.nextBigInteger())) System.out.println(1);
        else System.out.println(0);
    }
}
