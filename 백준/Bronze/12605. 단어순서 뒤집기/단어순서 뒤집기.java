
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/*
# 문제 해석 : 공백 기준 구분된 단어로 이루어진 문장을 입력받아 순서만 반대로. 뒤집기 X

# 로직 : 각 단어를 하나의 덩어리로 잘라서 스택에 넣었다가 빼면 됨

# 출력 : Case #1: 출력문
 */

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> stack = new Stack<>();
        int testCase = Integer.parseInt(br.readLine());
        int i = 1;
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                stack.push(st.nextToken());
            }
            int stackSize = stack.size(); // 스택에서 빼기 전 값을 지정하지 않으면 j는 늘고 size는 줄어서 대환장 파티가 일어남
            System.out.print("Case #" + (i++) + ": ");
            for (int j = 0; j < stackSize; j++) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }

    }
}
