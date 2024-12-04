import java.io.*;
import java.math.BigInteger;
import java.util.*;

/*
# 문제 : 보물 [실버 4] 1026

# 해석 : A의 최소값과 B의 최대값을 곱한 수를 모두 합하면 S의 최소값

# 입력 :
        Line 1 : A 와 B 배열의 길이가 주어진다
        Line 2 : 배열 A 의 구성
        Line 3 : 배열 B 의 구성

# 로직 : 우선순위 큐 활용
 */

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> A = new PriorityQueue<>();
        PriorityQueue<Integer> B = new PriorityQueue<>((a, b) -> b - a);

        int testCase = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < testCase; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < testCase; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }
        int result = 0;

        for (int i = 0; i < testCase; i++) {
            result += A.poll() * B.poll();
        }
        System.out.print(result);

    }
}