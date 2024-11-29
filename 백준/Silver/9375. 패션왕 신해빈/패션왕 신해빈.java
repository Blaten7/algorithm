import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
# 문제 해석 : 정신병자가 옷을 입을 수 있는 경우의 수를 구하는 문제.

# 로직 : 일단 해시맵에 담고 생각해보자

# 출력 :
 */

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            HashMap<String, Integer> map = new HashMap<>();
            int clothes = Integer.parseInt(br.readLine());
            while (clothes-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1); // 이름은 의미가 없음 종류별로 개수만 즈가
            }
//            if (map.size() == 1 || map.isEmpty()) {
//                for (int key : map.values()) {
//                    System.out.println(key-1);
//                }
//            } else {
//                int result = 1;
//                for (int key : map.values()) {
//                    result *= key;
//                }
//                System.out.println(result-1);
            int result = 1;
            for (int key : map.values()) {
                result *= key+1; // 해당 종류의 옷을 입지 않을 경우도 포함시켯서 +1
            }
            System.out.println(result - 1); // 다 벗었을 경우 빼고 계산
        }

    }
}