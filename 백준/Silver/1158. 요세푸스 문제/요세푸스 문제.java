import java.util.LinkedList;
import java.util.Queue;

interface Main {
    static void main(String[] x) {
        var s = new java.util.Scanner(System.in);

        int a = s.nextInt(); // 총 숫자 개수
        int index = s.nextInt(); // 제거할 인덱스

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= a; i++) { 
            q.offer(i); // 1부터 a까지 숫자 추가
        }

        System.out.print("<");
        while (!q.isEmpty()) {
            for (int i = 0; i < index - 1; i++) { 
                q.offer(q.poll()); // 인덱스에 맞게 순서 회전
            }
            System.out.print(q.poll()); // 현재 인덱스 요소 출력
            if (!q.isEmpty()) { // 큐가 비어있지 않으면 쉼표 추가
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}
