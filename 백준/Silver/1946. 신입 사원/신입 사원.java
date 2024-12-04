/*
# 문제 : 신입 사원 [실버 1] 1946

# 해석 : 문제 이해가 안가서 은주님 설명 참고하였음
     * - 서류심사 성적으로 먼저 정렬
     * - 서류심사 1등의 면접성적을 기준 면접 성적 점수 A로 설정(서류심사 1등은 무조건 합격)
     * - 서류심사 2등의 면접 성적이 A보다 높다면 합격자 수++, 기준 점수를 변경
     * - 서류심사 2등의 면접 성적이 A이하라면 불합격

# 입력 :
        Line 1 : 테스트 횟수
        Line 2 : 각 테스트의 지원자 수 N
           ~   : 서류, 면접 순위 N줄
        반복

# 로직 :
 */
import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
//            PriorityQueue<Map.Entry<Integer, Integer>> volunteer = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getKey));
            List<int[]> volunteer = new ArrayList<>();
            int volunteers = Integer.parseInt(br.readLine());
            Map<Integer, Integer> temp = new HashMap<>();
            while (volunteers-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int document = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                volunteer.add(new int[]{document, interview});
//                temp.put(document, interview);
//                volunteer.offer(temp.entrySet().iterator().next());
            }
            volunteer.sort(Comparator.comparingInt(a -> a[0]));
//            System.out.println(Arrays.deepToString(volunteer.toArray()));
            
            AtomicInteger count = new AtomicInteger(1);
            AtomicInteger lowInterview = new AtomicInteger(0);
            lowInterview.set(volunteer.get(0)[1]);
            volunteer.forEach(a -> {
                if (a[1] < lowInterview.get()) {
                    lowInterview.set(a[1]);
                    count.incrementAndGet();
                }
            });
            System.out.println(count.get());
        }
    }
}