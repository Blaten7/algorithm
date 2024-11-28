/*
# 문제 해석 : 스택에 정수를 담고, 가장 최근 값보다 큰 애들의 개수를 구하라. 최초 오른쪽 친구는 살려둬야 한다

# 로직 : pop 또는 peek 값보다 큰 친구들의 개수 +1

# 출력 : 한줄에 개수 출력
 */

import java.io.*;
import java.util.Stack;

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            stack.push(Integer.parseInt(br.readLine()));
        }
        int cnt = 1; // 비어있지 않으면 최소 1
        int stick = 0;
        while (!stack.isEmpty()) {

            if(stick == 0) {
                stick = stack.pop();
            } else {
                int k = stack.pop();
                if(stick < k) {
                    cnt++;
                    stick = k;
                }
            }
        }
        System.out.println(cnt);
    }
}
