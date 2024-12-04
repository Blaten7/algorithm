/*
# 문제 : 보석 도둑 [골드 2] 1202

# 해석 : 각각의 가격과 무게를 가진 N개의 보석을
        주어진 가방 K개 안에 몇 개나 담을 수 있는가

# 입력 :
        Line 1 : 보석개수 N + 가방개수 K
        Line 2 : N 개의 줄에, 각각의 무게 M 과 가격 V 가 주어짐
           ~   : 이후, 가방이 담을 수 있는 최대 무게 C가 주어짐
        가방이 담을 수 있는 최대무게와 관련없이
        각 가방에는 한 개의 보석만 담을 수 있음에 유의

# 로직 : 정수 배열로 각 보석의 무게와 가격을 담고
        가격이 비싼 순으로 보석의 무게가 가방의 최대 무게보다 낮은지 검증
        가방 개수 카운트해서 0이면 못담는거
        담았다면 가격을 총합에 +
        총합 출력
 */
import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long jewels = Long.parseLong(st.nextToken()); // 보석 갯수
        long b = Long.parseLong(st.nextToken()); // 가방 갯수
        AtomicLong bags = new AtomicLong(b);

        List<long[]> jewel = new ArrayList<>();
        for (int i = 0; i < jewels; i++) {
            st = new StringTokenizer(br.readLine());
            jewel.add(new long[]{Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())}); // [무게, 가격]
        }

        List<Long> bagList = new ArrayList<>();
        for (int i = 0; i < bags.get(); i++) {
            bagList.add(Long.parseLong(br.readLine())); // 가방 무게
        }

        jewel.sort(Comparator.comparingLong(a -> a[0]));

        Collections.sort(bagList);

        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        AtomicLong result = new AtomicLong(0);
        int index = 0;

        for (long bag : bagList) {
            while (index < jewel.size() && jewel.get(index)[0] <= bag) {
                pq.offer(jewel.get(index)[1]);
                index++;
            }
            if (!pq.isEmpty()) {
                result.addAndGet(pq.poll());
                bags.decrementAndGet();
            }
        }

        System.out.print(result.get());
    }
}
