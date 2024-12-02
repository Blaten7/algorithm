import java.io.*;
import java.util.PriorityQueue;

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < 28; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        for (int i = 1; i <= 30; i++) {
            if (!pq.isEmpty() && pq.peek() == i) { // 현재 번호가 존재하는 경우만 poll
                pq.poll();
            } else { // 존재하지 않으면 출력
                System.out.println(i);
            }
        }
    }
}
