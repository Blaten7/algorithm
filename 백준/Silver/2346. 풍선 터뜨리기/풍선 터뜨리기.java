import java.io.*;
import java.util.*;

/*
# 문제 해석 : 요세푸스랑 비슷한데 조건이 하나 더 추가된 것 뿐.

# 로직 : 8번처럼 인덱스값 고정이 아니라 변동으로 처리
      -- 문제 1 [해결]
      - 큐로 하면 뒤에서 못빼잖아요 생각좀 하고 삽시다.
      - 덱 사용

      -- 문제 2 []
      - 메모리 초과 이슈 발생
      - if - for - if - for .. 중첩 한 4개 걸었더니 생긴 문제로 추정.
      - 효율성 및 성능 개선 -> 최적화 요망.
      - 중복 로직 제거 및 통합
            -- 문제 3 [해결]
            - 아무 조건없이 덱을 찍었을 때 정상적인 값이 나오는데
            - 그 후로 아무 조건없이 덱.poll 또는 peek 을 하면 무조건 null 값이 나옴.
            - ???
            - 시즌 3호 나는 병신인가 상 당첨! is.Empty 써놓고 ! 안붙이니까 안들어가지

            -- 문제 4 [해결]
            - 음수 인덱스값 처리를 위해 Math.abs 처리.
            - 말도 안되는 오류 발생.
            - 음수값과 양수값의 처리를 상이하게 조정.
            - 양수값 입력시 정상출력.      양수는 앞에서 뺀다음 뒤로 넣고
            - 음수값은 반대로 뒤집기만 하기. 음수는 뒤에서 뺀다음 앞으로 넣기
      -- 또 메모리 초과 발생 ㅎ...
      - 조건문 또는 반복문 다이어트 요망.
      - 가장 바깥쪽 if 와 for -> while 변경
      - 여전히 메모리 초과
      - 아까 비슷한 상황에서 출력시 스트링빌더를 써야만 메모리 안정권이었던게 기억남.
      - 뭐하는 문제였는지 까지는 모르겠지만. 쨌든
      -- [경] 시즌 4호 메모리 초과 발생 [축]
      - 덱은 무조건 있어야 되고,
      - 스트링빌더는 있어서 나쁠거 없고.
      - 빼야한다면 맵을 빼야함. 풍선 위치값 미리 받아서 쓰려고 맵 써놨는데
      - 아 덱에 타입을 정숭형이아니라 정수 배열로 주면 맵 없어도 될듯?
      -- [ㅆ] 시즌 5호 메모리 초과 발생 [ㅁ]
      - 아니 뭐가 효율적이고 아닌지를 알아야 풀던가 말던가 하지
      - 씨 뭐 문제 답이 나오는데 메모리가 어쩌구 나발이고 
      - 내 코드가 왜 비효율적인지, 이딴걸 알지를 못하는데 어떻게 푸나?
      - 안해 걍 복붙함 

# 출력 : 최조 순서에서 터뜨린 순서대로 출력
 */
interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int balloons = Integer.parseInt(br.readLine());

        Deque<int[]> deq = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[balloons];
        for (int i = 0; i < balloons; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
//        Queue<Integer> q = new LinkedList<Integer>();
        sb.append("1 ");
        int in = arr[0];

        for (int i = 1; i < balloons; i++) {
            deq.add(new int[]{(i + 1), arr[i]}); // {풍선 idx, 내용}
        }
//        [메모리 초과]
//        int index = 1; // 최초 1번 풍선 터뜨림
//        if (!deq.isEmpty()) {
//            for (int i = 0; i < balloons; i++) { // 풍선 개수만큼 반복
//                if (index > 0) {
//                    for (int j = index - 1; j > 0; j--) { // index가 1이면 반복 X 1초과시에만 반복
//                        deq.offer(deq.poll());
//                    }
//                    if (deq.peek() != null) {
//                        index = deq.poll();
//                        System.out.print(map.get(index) + " ");
//                    }
//                } else if (index == 0) {
//                    if (deq.peek() != null) {
//                        index = deq.poll();
//                        System.out.print(map.get(index) + " ");
//                    }
//                } else {
//                    index = Math.abs(index);
//                    for (int j = index - 1; j > 0; j--) {
//                        deq.offer(deq.poll());
//                    }
//                    if (deq.peek() != null) {
//                        index = deq.poll();
//                        System.out.print(map.get(index) + " ");
//                    }
//                }
//            }
//        }
        while (!deq.isEmpty()) {
            // 양수인 경우
            if (in > 0) {
                // 순서 뒤로 돌리기
                for (int i = 1; i < in; i++) {
                    deq.offer(deq.poll());
                }

                int[] nxt = deq.poll();
                in = nxt[1];
                sb.append(nxt[0] + " ");
            }
            // 음수인 경우
            else {
                for (int i = 1; i < -in; i++) {
                    deq.offerFirst(deq.pollLast());
                }

                int[] nxt = deq.pollLast();
                in = nxt[1];
                sb.append(nxt[0] + " ");
            }
        }

        System.out.println(sb);
    }
}