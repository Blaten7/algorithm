import java.util.Scanner;

interface Main {
    static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        for (int i = 1; i <= a; i++) {
            System.out.print(i + " ");
            if (i % 6 == 0 || i == a) System.out.print("Go! ");
        }
    }
}