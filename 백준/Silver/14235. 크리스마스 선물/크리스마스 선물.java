import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
# 문제 해석 : 최대 힙 활용 문제

# 로직 :

# 출력 :
 */

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                System.out.println(!pq.isEmpty() ? pq.poll() : "-1");
            } else {
                while (st.hasMoreTokens()) {
                    pq.offer(Integer.parseInt(st.nextToken()));
                }
            }
        }
    }
}