import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            문제
            첫줄에 지시 횟수에 주어짐
            문자열로 판별해서 작업 수행
            덱구조. 6번 먼저 풀고 5번 풀었으면 도움됬을텐데..
            왜 순서가 이따위인걸까
         */
        Deque<Integer> deque = new ArrayDeque<>();
        int testCases = Integer.parseInt(br.readLine());
        while (testCases-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        bw.write("-1" + "\n");
                    } else {
                        bw.write(deque.getFirst() + "\n");
                        deque.removeFirst();
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        bw.write("-1" + "\n");
                    } else {
                        bw.write(deque.getLast() + "\n");
                        deque.removeLast();
                    }
                    break;
                case "size":
                    bw.write(deque.size() + "\n");
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        bw.write("1" + "\n");
                    } else {
                        bw.write("0" + "\n");
                    }
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        bw.write("-1" + "\n");
                    } else {
                        bw.write(deque.getFirst() + "\n");
                    }
                    break;
                    case "back":
                        if (deque.isEmpty()) {
                            bw.write("-1" + "\n");
                        } else {
                            bw.write(deque.getLast() + "\n");
                        }
                        break;
                default:
                    bw.write(command + "는 잘못된 명령어입니다" + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
