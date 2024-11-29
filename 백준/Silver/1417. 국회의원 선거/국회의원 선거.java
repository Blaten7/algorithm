import java.io.*;
import java.util.PriorityQueue;

/*
# 문제 해석 : 대한민국 나라 꼬라지를 단편적으로 보여주는 예시
           - 첫줄에 후보수.
           - 두번째 줄부터 1번 찍을 사람 수
           - 세번째 : 2번 찍을 사람 수 ...
           - 기호 1번, 즉 두번째줄이 가장 큰 값을 가지게 해야 할 때
           - 돈을 가성비 있게 쓰는 법

# 로직 : 문제에서 우선순위큐 쓰라니까 일단 그거 써봄

# 출력 : 사보타지 횟수를 출력
 */

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 최대 힙

        int fuckingKorea = Integer.parseInt(br.readLine()) - 1; // 부정부패의 상징을 제외한 국개의원의 수

        int rich = Integer.parseInt(br.readLine()); // 부정부패의 상징

        while (fuckingKorea--> 0) {
            pq.offer(Integer.parseInt(br.readLine())); // 1오 횡대 헤쳐모여!
        }
        int count = 0;

        while (!pq.isEmpty() && pq.peek() >= rich) { // 다른 사람의 예상 득표수가 더 높으면
            ++rich;                                  // 아무나 납치해서 내 창고에 한명 더 가둬두고
            pq.add(pq.poll() - 1);                   // 누군진 모르지만 암튼 그 진영 사람 한명 죽이고
            ++count;                                 // 정치공작 횟수 +1
        }
        // 천상천하 유아독존 달성시 루프 종료
        System.out.println(count);
    }
}