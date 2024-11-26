import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- >0) {
            String a = sc.next();
            String[] b = new String[a.length()];
            for (int i = 0; i < a.length(); i++) {
                b[i] = String.valueOf(a.charAt(i));
            }
            System.out.println(b[0]+b[a.length()-1]);
        }
    }
}