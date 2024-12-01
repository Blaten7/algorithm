import java.io.*;
import java.util.*;

/*
# 문제 : 콘서트 [브론즈 1] 16466

# 해석 : Line 1 : 1차 티켓팅 당시 팔린 티켓 개수 N (1 ≤ N ≤ 1,000,000)
        Line 2 : 1차 티켓팅 당시 팔린 티켓 번호 Ai (1 ≤ Ai ≤ 2^31 − 1)

# 로직 : 시간제한 1초, 메모리 500메가.
        입력의 최대 개수가 많음. 1부터 하나씩 있는지 체크해도 최대 O(N)이라 될 듯하다.
        최소 힙 우선큐에 담아서 정수 검증

# 이슈 : 시간초과 발생
        시간복잡도 계산에 오류가 있었음 O(N)이 아닌 O(N Log N) N이 최대 백만일때 약 20배가량 느림.
        빠른 조회를 위해 우선순위큐에서 해쉬 셋 사용으로 변경
 */

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> hs = new HashSet<>();

        int ticketNum = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (ticketNum-- > 0) {
            int ticket = Integer.parseInt(st.nextToken());
            hs.add(ticket);
        }
        int i = 1;
        while (true) {
            if (!hs.isEmpty() && hs.contains(i)) {
                i++;
            } else {
                System.out.print(i);
                return;
            }
        }
    }
}