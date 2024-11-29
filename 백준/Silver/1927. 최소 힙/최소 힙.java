
import java.io.*;
import java.util.PriorityQueue;

/*
# 문제 해석 :

# 로직 :

# 출력 :
 */

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 기본값이 최소 힙

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            int a = Integer.parseInt(br.readLine());
            if (a > 0) {
                pq.offer(a);
            } else if (a == 0) {
                System.out.println(!pq.isEmpty() ? pq.poll() : "0");
            }
        }


    }
}