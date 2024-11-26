import java.util.Scanner;

interface Main {
    static void main(String[]x) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int test = a*b;
        for (int i = 0; i < 5; i++) {
            int c = sc.nextInt();
            if (test == c) {
                System.out.print(0+" ");
            } else {
                int k = test - c;
                k = -k;
                System.out.print(k+" ");
            }
        }

    }
}
