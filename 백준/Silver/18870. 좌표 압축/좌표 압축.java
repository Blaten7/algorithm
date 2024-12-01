import java.io.*;
import java.util.*;

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Map<Integer, Integer> rankMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬된 중복 제거 리스트 생성
        int[] sortedArr = Arrays.copyOf(arr, N);
        Arrays.sort(sortedArr);

        // 순위 매핑
        int rank = 0;
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(rankMap.get(num)).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
