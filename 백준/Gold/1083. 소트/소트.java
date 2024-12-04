/*
# 문제 : 소트 [골드 4] 1083

# 해석 : 정렬 수동 구현, S값 카운트로 횟수 제한

# 입력 :
        Line 1 : 배열의 크기 N이 주어짐
        Line 2 : 배열의 구성 값이 주어짐
        Line 3 : S의 횟수가 주어짐

# 로직 : 정렬메서드를 사용하지 않고 수동으로 정렬을 구현
 */
import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> A = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
//        AtomicInteger count = new AtomicInteger(Integer.parseInt(br.readLine()));
        int count = Integer.parseInt(br.readLine());
//        A.sort((a, b) -> {
//            System.out.println("a : " + a + " b : " + b);
//            if (a > b && count.get() > 0) {
////                System.out.println("일하고 있나");
//                count.getAndDecrement();
//                return b - a;
//            } else {
//                return 0;
//            }
//        });
        for (int i = 0; i < N && count > 0; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < N && j <= i + count; j++) {
                if (A.get(j) > A.get(maxIdx)) {
                    maxIdx = j;
                }
            }

            if (maxIdx != i) {
                int maxValue = A.get(maxIdx);
                A.remove(maxIdx);
                A.add(i, maxValue);

                count -= (maxIdx - i);
            }
        }
        A.forEach(num -> System.out.print(num + " "));
    }
}
