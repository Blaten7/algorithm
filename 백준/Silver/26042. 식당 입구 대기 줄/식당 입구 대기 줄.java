
/*
# 문제 : 식당 입구 대기 줄 [실버 5] 26042

# 해석 :
        Line 1 : 테스트 회수
        Line 2 : 1 a => 양의 정수 a가 식당에 도착, 줄을 섬
        line 3 : 2 -> 식사준비 완료, 1명 감소


# 로직 : 큐 사용? 덱으로 변경.
        대기줄의 마지막 학생번호를 추출해서 최소값을 구해야 하기 때문에

# 이슈 :
 */

import java.io.*;
import java.util.*;

interface Main {
    static void main(String[] x) throws IOException {
        Scanner sc = new Scanner(System.in);

        int testCase = Integer.parseInt(sc.nextLine());

        Deque<Integer> q = new LinkedList<>();

        int maxLength = 0;
        int smallNum = 100000;

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int student = Integer.parseInt(st.nextToken());
                q.offer(student);
                if (q.size() > maxLength) {
                    maxLength = q.size();
                    smallNum = student;
                } else if (q.size() == maxLength) {
                    smallNum = Math.min(student, smallNum);
                }
            } else if (!q.isEmpty()) {
                q.poll();
            }
        }
        System.out.print(maxLength + " " + smallNum);
    }
}