import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1; // 배열은 0부터 시작하기 떄문에 arr[0]에 1을 넣기 위해 1을 더해줌
        }

        for (int i = 0; i < M; i++) { // M개의 줄
            int left = sc.nextInt() - 1; // 배열 0부터 시작
            int right = sc.nextInt() - 1;

            while (left < right) {
                int temp = arr[left];
                arr[left++] = arr[right];
                arr[right--] = temp;
            }
        }
        sc.close();

        for (int baguni:arr)
            System.out.print(baguni + " ");
    }
}
