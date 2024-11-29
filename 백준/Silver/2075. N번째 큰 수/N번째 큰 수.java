
import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
# 문제 해석 :

# 로직 :

# 출력 :
 */

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 최대 힙

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");
            for (int j = 0; j < n; j++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 0; i < n-1; i++) {
            pq.poll();
        }
        System.out.println(pq.poll());
    }
}