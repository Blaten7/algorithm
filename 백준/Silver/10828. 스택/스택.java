
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/*
# 문제 : 스택의 이해, 명령어별 처리 프로그램 제작

# 로직 : 명령어 다 저장 대충 생각하는대로~

# 출력 : 즉시 출력 조건이 있을시 바로, 아님말고
 */

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    System.out.println(stack.isEmpty() ? "-1" : stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.isEmpty() ? "1" : "0");
                    break;
                case "top":
                    System.out.println(stack.isEmpty() ? "-1" : stack.peek());
                    break;
            }
        }


    }
}
