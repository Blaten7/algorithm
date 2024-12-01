import java.io.*;
import java.util.*;

/*
# 문제 : 좌표 압축 [실버 2] 18870

# 해석 : 한 줄에 공백으로 구분된 X1, X2, ... XN
        Xi 를 좌표 압축한 결과 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj 개의 개수와 같아야 함.
        입력받은 좌표를 압축한 결과를 공백구분 한줄로 출력.
        모든 좌표값 중에서 Xi 보다 작고, 서로 다른 좌표의 개수가 몇개인지.
        중복 제거하고, 몇 번째로 작은 수인지 순위 계산

# 로직 : 순위를 확인하려는 원래 값들을 저장한 배열
        중복제거하고 편하게 꺼내오기 위한 트리셋
        indexOf 로 특정 인덱스에 접근하기 위한 리스트 사용

# 이슈 : 시간초과 발생
        시간복잡도 계산이 익숙치 않아 GPT 사용
        기존 로직 - 배열과 트리셋에 담고 트리셋의 데이터를 리스트에 담고,
                   list.indexOf(arr[i])로 출력 = > O(N^2)
        배열 두개에 같은 값을 저장하고, 하나는 그대로 두고 다른 하나만 정렬.
        정렬된 배열, 즉 작은 값부터 0순위를 매겨서 맵에 저장.
        그냥 배열의 값을 순서대로 불러와서 순위 출력

        시간초과 발생
        출력이 최대 100만개, 스트링빌더 필요
        앞으로 테스트할 때에는 일반출력,
        테스트가 아닐 때에는 스트링빌더 사용을 습관화 하도록 노력
 */

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sort = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            arr[i] = a;
            sort[i] = a;
        }
        Arrays.sort(sort);

        int rank = 0;
        for (int num : sort) {
            if (!map.containsKey(num)) {
                map.put(num, rank);
                rank++;
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            result.append(map.get(arr[i])).append(" ");
        }
        System.out.println(result);
    }
}