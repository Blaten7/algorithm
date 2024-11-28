
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
# 문제 : 큐의 이해, 명령어별 처리 프로그램 제작

# 로직 : 명령어 다 저장 대충 생각하는대로~

# 출력 : 즉시 출력 조건이 있을시 바로, 아님말고
 */

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<Integer>();

        int testCase = Integer.parseInt(br.readLine());
        int lastTask = 0;
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int k = 0;
            switch (cmd) {
                case "push":
                    k = Integer.parseInt(st.nextToken());
                    q.offer(k); // 큐 사용시 add 는 값 추가 실패시 예외가 펑 하고 터지고, offer는 false를 정중하게 반환한다..
                    lastTask = k;
                    break;
                case "pop":
                    if (q.isEmpty()) {
                        System.out.println("-1");
                    } else System.out.println(q.poll()); // remove 와 poll 또한 위와 같다
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    System.out.println(q.isEmpty() ? "1" : "0");
                    break;
                case "front":
                    if (q.isEmpty()) {
                        System.out.println("-1");
                    } else System.out.println(q.peek());
                    break;
                case "back":
                    if (q.isEmpty()) {
                        System.out.println("-1");
                    } else System.out.println(lastTask);
            }
        }

    }
}
