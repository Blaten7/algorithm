/*
Silver4_30번_13116

# 해석 : 시간제한 2초, 메모리제한 512MB
        07년 수능 수리 가형 30번 문항과 유사한 문제를 풀이.

        1023개의 정점을 갖는 이진트리
        1이 대응된 정점에서 a가 대응된 정점까지 가는 경로와 // 1 부터 a 까지 스쳐간 정점
        1이 대응된 정점에서 b가 대응된 정점까지 가는 경로에 // 1 부터 b 까지 스쳐간 정점 간 공통 정점 중 최대값
        공통으로 포함되는 정점 중 최대값을 M(a, b) 라고 함.
        EX => M(4, 11) = 2, M(7, 12) = 3.

# 입력 :
        Line 1 : 테스트 케이스의 갯수 T (1 ≤ T ≤ 50 000) // 각 테스트는 1줄로 구성.

        Line 2 : 두 개의 정수 A와 B (1 ≤ A, B ≤ 1 023, A ≠ B) 입력

# 로직 : BFS 사용해서 풀어보기.
        아직 익숙하지 않은 알고리즘이라 말 또는 글로써 설명하기 어려움.

        시도 1 : 메인 클래스를 인터페이스로 변경, M(a, b) 메서드 생성하여 풀이 시도
                의식의 흐름대로 하다보니 큐값 복사해서 두개 만들고 리스트도 복사되어있는 등
                문제가 많아보임. 폐기

        시도 2 : 중복되는거 합치고, 로직을 조금더 효율적으로 개선했다고 생각했는데.
                내가 강의에서 본 DFS, BFS와는 좀 많이 다른것같아서 찾아보니까 아님..
                ?
 */

import java.io.*;
import java.util.*;

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            System.out.println(M(A, B) * 10);
        }
        // 테스트 코드
//        st = new StringTokenizer(br.readLine());
//        int A = Integer.parseInt(st.nextToken());
//        int B = Integer.parseInt(st.nextToken());
//        System.out.println(M(A, B) * 10);
    }

    static int M(int a, int b) {
        HashSet<Integer> resultA = new HashSet<>();
        HashSet<Integer> resultB = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            resultA.add(x);
            queue.add(x / 2);
            if (x == 1) break;
        }
        queue.add(b);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            resultB.add(x);
            queue.add(x / 2);
            if (x == 1) break;
        }
        resultA.retainAll(resultB); // A와 B중 공통된 수만 남김

        if (resultA.isEmpty()) return -1; // 공통된 수가 없을 경우 -1 반환

        return Collections.max(resultA);
    }
}
