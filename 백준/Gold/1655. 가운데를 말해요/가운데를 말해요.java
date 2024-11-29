import java.io.*;
import java.util.*;

/*
# 문제 : 가운데를 말해요 [골드 2], 1655

# 해석 : 남은 네문제중에 티어는 제일 높은데 제일 쉬워보여서 첫번째로 고름.
      - 첫 라인에 테스트 케이스 갯수.
      - 숫자가 주어질때마다 지금까지 말한 수중에서 중간값을 출력.
      - 숫자가 하나라면 그냥 그거, 짝수라면 가운데 두 개 중에서 작은값 출력.
      정수 개수는 1이상 10만 이하 자연수
      정수의 값은 -1만 이상 1만 이하.

# 로직 : 우선순위 큐 활용해서 최소 힙으로 담고,
      - 짝수일때는 큐의 길이던 사이즈던 구해서 2로 나누고 -1한 인덱스의 값.
      - 을 구해서 빼고 더하고 빼고 더하고? 우선큐에서 그게 의미가 있나? 없는데
      - 우선큐에서 인덱스에 접근이 되나?
      - 1321351퍼 안될거 알지만 당장 생각나는게 없기 때문에 일단 머리 박기
      - 박아보다가 안건데, 문제 하단의 알고리즘 분류 => 우선순위 큐가 있따,
      - 그 말인즉슨, 머리가 깨질 때까지 박아도 된다는 것!

# 이슈 :
      -- 문제 1 []
      - 인덱스에 접근하여 직접 조작하기 위해 우선큐를 리스트로 복제후 값을 뽑아옴.
      - 복제한 리스트의 순서는 일관적이지 않아서 다시 정렬을 해줘야 한다는 걸 몰라서 헤맴.
      - 뭐 되기는 하는데 시간초과 문제 발생.
      - 시간이 0.1초가 말인가?
      - 진짜 극도로 효율적으로 짜야하는데
      - 그러면 지금 내 코드의 시간복잡도를 먼저 살펴보자
      - 우선큐에서 값 입력은 O(Log n)
      - 큐 -> 리스트 변환 O(n)
      - 리스트 정렬 O(n Log n)
      - 리스트에서 인덱스 접근 O(1)
      - 토탈 시간복잡도 계산은 어떻게하는건지 몰라서 지선생 시킴. O(n^n Log n)
      - 잘은 모르지만 아무튼 빨라보이진 않음
      - 전혀 모르겠어서 힌트를 받음
      - 최소힙과 최대힙을 같이 써서 풀어보라고 함,

 */

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 첫 번째 값 기준 오름차순
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

//        boolean isMax = true;
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
//        int[] k = new int[testCase];
        while (testCase-- > 0) {
            int num = Integer.parseInt(br.readLine());
            // 최초 1회 값 그냥 넣기, 최대힙은 중간값보다 작은값만 있어야 하고, 최소힙은 중간값보다 크거나 같아야함
            if (max.isEmpty() || num <= max.peek()) { // 신입이 최대힙의 최대값보다 작으면 최대힙에 넣고
                max.offer(num);
            } else {
                min.offer(num); // 아니면 최소힙에 넣음. 
            }
            // 1부터 10까지의 수를 순서대로 넣는다고 할 때
            // 최소힙은 6 7 8 9 10
            // 최대힙은 5 4 3 2 1
            // 짝수개일때는 가운데 두 개 중에 작은수니 최대힙의 최대값 5
            // 홀수개 일때, 9까지의 경우에도 최대힙의 최대값.

            if (max.size() > min.size() + 1) {
                min.offer(max.poll());
            } else if (min.size() > max.size()) {
                max.offer(min.poll());
            }
            sb.append(max.peek()).append("\n");
//            int a = Integer.parseInt(br.readLine());
//            pq.offer(new int[]{index, a});
            // pq.peek or pq.poll [0] - > 인덱스 번호
            // pq.peek or pq.poll [1] - > 값
//            List<int[]> list = new ArrayList<>(pq); // 특정 인덱스 접근을 위한 리스트
//            list.sort(Comparator.comparingInt(o -> o[1])); // 값 기준 정렬
//            if (pq.size() == 1) {
            // 최초 반복문 진입시 첫번째 값 출력
//                System.out.println(pq.peek()[1]);
//            } else if (!pq.isEmpty() && pq.size()%2 == 0) {
            // 큐의 길이가 짝수라면, 가운데 두개 중에 작은값 출력.
            // 예를들어서 길이가 10이야, 그러면 인덱스가 0 부터 9까지 있겠지?
            // 그러면 가운데 두 수는 4,5인거고 길이/2 - 1의 인덱스.
//                큐 길이 짝수 일때 인덱스
//                1 2 3 4 5 6 7 8
//                길이는 8
//                가운데 수는 4 5
//                이중에 작은거 4
//                인덱스는 3
//                길이/2 -1
//                System.out.println(list.get(pq.size()/2 - 1)[1]);
//            } else {
            // 큐의 길이가 홀수라면, 가운데값 출력.
//                큐 길이 홀수 일때 인덱스
//                1 2 3 4 5 6 7 8 9
//                길이 = 9,
//                        가운데 수 = 5.
//                인덱스는 4
//                길이-1/2
//                System.out.println(list.get((pq.size()-1)/2)[1]);
//            }
//        }
//        System.out.println("============");
//        while (!pq.isEmpty()) {
//            int[] element = pq.poll();
//            System.out.println("[" + element[0] + ", " + element[1] + "]");
        }
        System.out.println(sb);
    }
}