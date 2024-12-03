import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
# 문제 : 파일 합치기 3 [골드 4] 13975

# 해석 : 소설가, 각 장을 서로 다른 파일에 저장
        모든 장을 다 쓴 후, 하나로 합침

        합치는 과정  =>  두 개의 파일을 합쳐서 하나의 임시파일 생성
                       임시파일 또는 원래 파일을 계속 두개씩 합침

        두 개의 파일을 합치는 비용이 두 파일 크기의 합이라고 가정,
        최종 파일을 완성하는데 필요한 비용의 합을 계산하라

        ex) C1(40), C2(30), C3(30), C4(50)
        => C2 + C3 = X1 / 60
        => C1 + X1 = X2 / 100
        => C4 + X2 = Y  / 150  // 310 X

        => C1 + C2 = X1 / 70
        => C3 + C4 = X2 / 80
        => X1 + X2 = Y  / 150 // 300 O

# 입력 : 각 테스트는 두 줄로 이루어지며, 가장 처음은 테스트의 횟수.
        테스트의 첫 번째 행은 소설이 몇 장으로 구성되어 있는지,
        두 번째 행은 각 파일의 비용

# 로직 : 문제 읽자마자 그리디 알고리즘이구나 했는데
        정작 그리디 알고리즘은 이해못함
        해당 알고리즘을 모르기 때문에
        리스트에 담아서, 리스트 사이즈가 0이 될때까지 while
        처음에 그리디에 매몰되서 우선순위큐가 생각이 나지 않음
        우선큐로 최소값 두개 뽑아서 더하고 다시 넣고 생각

        - 비용의 합이 정상적으로 계산되지 않음.
        단순히 우선큐에 합을 구하는게 아니고, 그 합을 구하기까지의 합을 다 더해야함.

        - 결과값 int도 쓰면 안되는듯? 아마도. 중간테스트 다 해봤는데 로직의 오류는 없는 것 같다
        - 결과값 뿐 아니라 중간값도 long으로. 안되면 BigInteger 쓸 생각도

 */

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
//            List<Integer> list = new ArrayList<Integer>();
            PriorityQueue<Long> q = new PriorityQueue<>();
            int novel = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
//                list.add(Integer.parseInt(st.nextToken()));
                q.offer(Long.parseLong(st.nextToken()));
            }
            long result = 0;
            while (q.size() > 1) {
                long a = 0, b = 0;
                a = q.poll();
                if (!q.isEmpty()) {
                    b = q.poll();
                }
                result += a + b;
                q.offer(a + b);
            }
            System.out.println(result);
//            list.sort((i1, i2) -> {
//                return Integer.compare(i1, i2);
//            });

//            List<Integer> afterList = new ArrayList<Integer>();
//            int i = 0;
//            while (!list.isEmpty()) {
//                int a = 0, b = 0;
//                if (!list.isEmpty()) {
//                    a = list.get(i);
//                    list.remove(i);
//                }
//                if (!list.isEmpty()) {
//                    b = list.get(i + 1);
//                    list.remove(i+1);
//                }
//                afterList.add(a+b);
        }
//            System.out.println(afterList);
    }

}