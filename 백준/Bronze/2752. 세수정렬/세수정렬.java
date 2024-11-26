import java.util.Scanner;
import java.util.Arrays;

interface Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int[] numbers = {a, b, c};

        Arrays.sort(numbers);

        System.out.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);
    }
}
