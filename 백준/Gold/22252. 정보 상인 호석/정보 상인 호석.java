
import java.io.*;
import java.util.*;

/*
# 문제 해석 :
            1 NAME k [] -> 이름이 NAME 인 고릴라가 k개의 정보를 얻음 그 가치는 k[k-1]..로 구성
            2 NAME n    -> 이름이 NAME 인 고릴라에게 n개의 정보를 삼 k>n ? k에서 비싼것만 n개 삼 : 다삼

# 로직 : 몰라요 하면서 생각할게요

# 출력 : 정보를 구매하는데 쓴 돈의 총합
 */
interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        int testCase = Integer.parseInt(br.readLine());
        long result = 0;
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            String name = st.nextToken();
            switch (cmd) {
                case "1":
                    int infoNum = Integer.parseInt(st.nextToken()); // 정보의 개수
//                    Integer[] info = new Integer[information];
                    ArrayList<Integer> info = new ArrayList<>(); // 첫번째 열 기준 10, 4, 2, 8, 4 가 저장될 리스트
                    for (int i = 0; i < infoNum; i++) {
                        info.add(Integer.parseInt(st.nextToken()));
                    }
                    if (map.get(name) == null) { // 저장된 이름이 없어, 그러면 그냥 저장해
                        map.put(name, new ArrayList<>(info));
                    } else {
                        ArrayList<Integer> exist = map.get(name); // 기존 값 가져오기
                        exist.addAll(info); // addAll 을 쓰면 리스트간 병합이 가능. 그냥 add 로는 안됨
                        map.put(name, new ArrayList<>(exist));
                    }
                    break;
                case "2":
                    if (map.get(name) != null) continue;
                    ArrayList<Integer> exist = map.get(name);

                    if (exist == null || exist.isEmpty()) {
                        continue;
                    }
                    int pay = Integer.parseInt(st.nextToken()); // 정보 몇개 살건지
                    if (pay >= exist.size()) { // 가진 정보보다 사려는게 많으면 다삼
                        for (int i = exist.size() - 1; i >= 0; i--) { // 역순으로 제거
                            result += exist.get(i);
                            exist.remove(i);
                        }
                    } else {
                        Collections.sort(exist); // min ...... max 정렬
                        for (int i = 0; i < pay; i++) {
                            result += exist.get(exist.size() - 1);
                            exist.remove(exist.size() - 1);
                        }
                    }
                    map.put(name, new ArrayList<>(exist));
                    break;
            }
        }
//        StringBuilder sb = new StringBuilder();
////        map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + Arrays.deepToString(value)));
//        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
//            sb.append("NAME : " + entry.getKey() + " INFORMATION : " + entry.getValue() + "\n");
//        }
//        System.out.println(sb.toString());
        System.out.println(result);

        시간초과 발생 // 시간초과 메모리 초과 뜨더라도 로직은 맞는지 부분점수 1점만 주면 안되나...
        요즘들어 문제를 대충 읽는 경향이 생겼는데
        사실 풀다가 중반쯤부터 이렇게 푸는게 아니고 우선순위 큐, 영어로는 PriorityQueue 써야한다는 걸 알고는 있었긴 한데
        그냥 끝을 보고 싶어서 시간을 열심히 땅에 갖다 버림 신난다

*/
        int testCase = Integer.parseInt(br.readLine());

        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        long result = 0;
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int count = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                for (int j = 0; j < count; j++) {
                    if (!map.containsKey(name)) {
                        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                        pq.add(Integer.parseInt(st.nextToken()));
                        map.put(name, pq);
                    } else {
                        map.get(name).add(Integer.parseInt(st.nextToken()));
                    }
                }
            } else {
                if (map.get(name) == null) continue;
                while (!map.get(name).isEmpty() && count > 0) {
                    result += map.get(name).poll();
                    count--;
                }
            }
        }
        System.out.println(result);
    }
}
