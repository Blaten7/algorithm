import java.util.Scanner;

interface Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 1; i <= test; i++) {
            System.out.println(" ".repeat(test-i)+"*".repeat(i));
        }
    }
}