/*
# 문제 : 보물 [실버 4] 1026

# 해석 : 길이가 N인 정수 배열 A, B
        함수 S = A[0] × B[0] + ... + A[N-1] × B[N-1]
        S의 값을 가장 작게 만들 수 있도록 A를 재배열. B는 재배열 금지.
        S의 최소값을 출력

# 로직 : 함수 S의 최소값을 만들기 위해서는
        B 배열의 숫자중 최대값과
        A 배열의 숫자중 최소값을 곱해야 함.
        B 정렬이 되었다면, 우선순위 큐 최소힙 최대힙 두개로 간단하게 풀 수 있겠으나
        .. 일단 A를 최소 힙으로 저장.
        B에서 첫번째 값이 모든 값중에 몇번째로 큰지 찾는 로직을 구현하면 해결될듯 함
        일단 우선순위큐 두개로 제출해보고 안되면 생각하는 것으로.

# 이슈 :
 */

import java.io.*;
import java.util.*;

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> A = new PriorityQueue<>();
        PriorityQueue<Integer> B = new PriorityQueue<>((a, b) -> b - a);

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.offer(Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B.offer(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += A.poll() * B.poll();
        }
        System.out.print(result);

    }
}