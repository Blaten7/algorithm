import java.io.*;
import java.util.*;

/*
# 문제 : 좌표 압축 [실버 2] 18870

# 해석 : 최고 순위는 0, 한 라인에 공백으로 구분되어 주어지는 배열중에, 각 정수가 가지는 순위를 출력

# 입력 :
        Line 1 : 배열의 길이.
        Line 2 : 배열의 구성

# 로직 : 정수를 리스트에 저장하고, 오름차순 정렬한 값과 순위를 맵에 저장. 리스트를 순회하며 순위값 출력
 */

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        int[] A = new int[testCase];
        int[] B = new int[testCase];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int a = Integer.parseInt(st.nextToken());
            A[i] = a;
            B[i] = a;
        }
        Arrays.sort(B);

        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < testCase; i++) {
            if (!map.containsKey(B[i])) {
                map.put(B[i], rank);
                rank++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            sb.append(map.get(A[i])).append(" ");
        }
        System.out.print(sb);
    }
}