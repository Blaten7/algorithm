import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        while (a-- >0) {
            int c = sc.nextInt();
            if (c < b) {
                System.out.print(c + " ");
            }
        }
        
    }
}