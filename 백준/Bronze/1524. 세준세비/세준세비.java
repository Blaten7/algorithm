/*
# 문제 : 세준세비 [브론즈 1] 1524

# 해석 : 세준이가 키운 N명의 병사와
        세비가 키운 M명의 병사가 전쟁을 함
        한 번의 전투에서 양 진영을 통틀어 가장 약한 병사가 사망한다.
        가장 약한 병사가 한 진영에만 있다면 아무나 죽는다.
        두 진영에 모두 있다면 세비의 병사가 사망한다.
        한 명의 병사만 살아남았을 때 전쟁이 종료된다.
        전쟁의 승자를 출력하라
        세준 = S, 세비 = B, 무승부 = C

# 로직 : 우선순위 큐 최소힙으로 두개 구현,
        peek 로 비교하고, 사망시 poll
        s.size + b.size = 1 일때 종료

# 이슈 :
 */

import java.io.*;
import java.util.*;

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            PriorityQueue<Integer> S = new PriorityQueue<>();
            PriorityQueue<Integer> B = new PriorityQueue<>();
//            System.out.println("게임시작");
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sejun = Integer.parseInt(st.nextToken());
            int sebi = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            while (sejun-- > 0) {
                S.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            while (sebi-- > 0) {
                B.add(Integer.parseInt(st.nextToken()));
            }
            while (true) {
//                System.out.println("전쟁 중");
                if (!S.isEmpty() && !B.isEmpty()) {
                    if (S.peek() < B.peek()) {
                        S.poll();
                    } else {
                        B.poll();
                    }
                }
//                System.out.println("세준 병력 : " + S.size());
//                System.out.println("세비 병력 : " + B.size());
                // 둘 중 하나가 전멸하거나, 둘 다 아닐때 C.
                // 어떤 경우에 C가 출력될 수 있는지 모르겠음
                if (S.isEmpty() || B.isEmpty()) {
                    if (S.isEmpty()) {
                        System.out.println("B");
                    }
                    if (B.isEmpty()) {
                        System.out.println("S");
                    }
                    break;
                }
            }
        }
    }
}