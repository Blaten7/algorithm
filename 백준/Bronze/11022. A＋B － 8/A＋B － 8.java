import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int i = 1;
        while (a-- >0) {
            int b = sc.nextInt();
            int c = sc.nextInt();
            System.out.println("Case #"+i+": "+b+" + "+c+" = "+(b+c));
            i++;
        }
    }
}