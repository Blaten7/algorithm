import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,H,T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        String answer = "NO";
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int cnt = 0;
        for (int i = 0; i < T; i++) {

            // 최장신이 나보다 작거나 1일경우 break;
            if ((pq.peek() < H) || (pq.peek() == 1)) break;
            cnt++;
            pq.add(pq.poll() / 2);
        }
        if (pq.peek() < H) answer = "YES";
        StringBuilder sb = new StringBuilder(answer);
        sb.append("\n").append(answer.equals("YES") ? cnt : pq.poll());
        System.out.print(sb);
    }
}
