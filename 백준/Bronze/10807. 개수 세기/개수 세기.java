import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 번째 줄: 정수의 개수 N
        int N = sc.nextInt();

        // 두 번째 줄: N개의 정수 입력
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        // 세 번째 줄: 찾으려는 정수 v
        int v = sc.nextInt();

        // v의 개수 카운트
        int count = 0;
        for (int num : numbers) {
            if (num == v) {
                count++;
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}
