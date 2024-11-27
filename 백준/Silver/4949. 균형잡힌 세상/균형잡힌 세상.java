import java.io.*;
import java.util.*;

/*
# 문제 해석 : 이것도 스택인 것 같음. 문자열 분해해서 괄호의 경우에만 추가하고, 같은게 있으면 제거

# 로직 : 위와 같음

# 출력 : 스택이 비어있으면 균형이 맞는거니까 yes, 뭐가 있으면 no를 출력

 */
interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        while (!line.equals(".")) {
            Stack<String> stack = new Stack<>();
            for (char c : line.toCharArray()) {
                switch (c) {
                    case '(':
                    case ')':
                    case '[':
                    case ']':
                        if (stack.empty()) {
                            stack.push(String.valueOf(c));
                        } else {
                            String compare = stack.pop();
                            switch (compare) {
                                case "(":
                                    if (c != ')') {
                                        stack.push(compare);
                                        stack.push(String.valueOf(c));
                                    }
                                    break;
                                case "[":
                                    if (c != ']') {
                                        stack.push(compare);
                                        stack.push(String.valueOf(c));
                                    }
                                    break;
                                case ")":
                                case "]":
                                    stack.push(compare);
                                    break;
                            }
                        }
                        break;
                    default:
                        continue;
                }
            }
            if (stack.empty()) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
            line = br.readLine();
        }
        bw.flush();

    }
}