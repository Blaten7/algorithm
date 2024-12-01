/*
# 문제 : 팀명 정하기 [브론즈 2] 28114

# 해석 : 팀명을 정하는 방법
        세 참가자의 입학 연도를 100으로 나눈 나머지 %를 오름차순으로 정렬, 이어붙인 문자열
        성씨를 영문으로 표기했을때, 첫 글자를 해결 문제가 많은 사람부터 정렬하여 붙인 문자열
        600문제 해결 18학번 안(AHN), 2000문제 해결 19학번 이(LEE), 6000문제 해결 20학번 오(OH)
        첫 번째 방법으로 팀명을 만들면 181920이 되고,
        두 번째 방법으로 팀명을 만들면 OLA

        세 팀원이 주어지면 첫번째 방법과 두번째 방법의 팀명을 줄 바꿔 출력

# 로직 : 시간제한 2초에 메모리도 넉넉해서 큐 두개 써서 정렬하고 출력

 */

import java.io.*;
import java.util.*;

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        TreeMap<Integer, Character> hm = new TreeMap<>();
        int three = 3;
        StringBuilder teamName = new StringBuilder();
        while (three-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int problem = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken())%100;
            String name = st.nextToken();
            pq.offer(year);
            hm.put(problem, name.charAt(0));
        }
        for (int i=0; i<3; i++) {
            teamName.append(pq.poll());
        }
        System.out.println(teamName);
        teamName.setLength(0);
        for (Character val : hm.values()) {
            teamName.append(val);
        }
        System.out.println(teamName.reverse());
    }
}