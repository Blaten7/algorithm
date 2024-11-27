/*
# 문제 해석 :

# 로직 :

# 출력 :
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test  = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            Stack<Character> stack = new Stack<>();
            String line = br.readLine();
            for (char c : line.toCharArray()) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (stack.peek() == '(' && c == ')') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            System.out.println(stack.isEmpty()?"YES":"NO");
        }

    }
}
