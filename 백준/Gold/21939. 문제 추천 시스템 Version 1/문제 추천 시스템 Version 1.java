import java.io.*;
import java.util.*;

/*
# 문제 : 문제 추천 시스템 Version 1 [골드 4], 21939

# 해석 :
            깃허브에 코딩테스트 문제를 [ 문제번호, 난이도 ] 로 정리해 놓음

            -> recommend x =    x 가 1인 경우 리스트에서 난이도가 가장 높은 문제의 번호를 출력
                                난이도가 같은 문제가 여러개 일 경우, 번호가 가장 높은 것
                                x 가 -1인 경우 리스트에서 난이도가 가장 낮은 문제의 번호를 출력
                                난이도가 같은 문제가 여러개 일 경우, 번호가 가장 낮은 것
                                리스트에 문제가 없을 경우 해당 명령어는 입력되지 않음

            -> add P L =        리스트에 난이도가 L인 문제번호 P를 추가
                                리스트에 없는 번호 P만 입력으로 주어짐
                                리스트에 있던 문제 번호가 다른 난이도로 들어올 수 있음
                                즉, L과 P과 모두 동일한 문제는 입력되지 않음

            -> solved P =       리스트에서 문제번호 P를 제거.
                                리스트에 있는 번호만 입력으로 주어짐.

            위의 기능 세가지를 새롭게 추가

# 입력 :
            Line 1 : 현재 문제의 갯수 N
            Line 2 :
             ...     N개의 라인에 문제번호, 난이도가 공백 구분 입력
            Line 6 :
            Line 7 : 명령어의 갯수 M
            Line 8 :
             ...     M개의 명령어 입력
            Line 16 :

# 로직 :
            문제번호와 난이도가 모두 같은 입력은 없음 => 중복값 처리 로직 불필요
            명령어가 recommend 일때만 출력. 1 최대값, -1 최소값
            - 해시맵에 저장. 한 개의 해시맵 사용만으로는 한계를 느낌.
            - 트리맵 사용으로 변경, 단순 삽입/조회/삭제 일때는 해시맵이 더 좋지만
            - 정렬 횟수가 빈번하거나 최소값, 최대값에 접근하기 위해서 기본정렬되는 트리맵 우선
            - 삽입/조회/삭제시 해시맵 사용.
            - 그 외 작업시 트리맵으로 병렬 사용
            - 난이도가 같은 문제가 여러개일 경우 별도의 정렬작업이 필요
            - 별도 정렬시 시간초과 발생. 자동으로 정렬될 필요

# 이슈 :
 */

interface Main {
    static void main(String[] z) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        HashMap<Integer, Integer> hMap = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> tMap = new TreeMap<>();

        int a = Integer.parseInt(br.readLine());
        while (a-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int problemNum = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            hMap.put(problemNum, level);
            tMap.putIfAbsent(level, new TreeSet<>());
            tMap.get(level).add(problemNum);
        }

        //        List<Integer> keySet = new ArrayList<>(map.keySet());

        int b = Integer.parseInt(br.readLine());
        while (b-- > 0) {
//            tMap.clear();
//            tMap.putAll(hMap);
//            System.out.print("현재 티맵 구성 : ");
//            System.out.println(tMap);
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int P = 0;
            switch (command) {
                case "recommend":
                    int x = Integer.parseInt(st.nextToken());
                    if (x == -1) {
//                        Collections.sort(val);
//                        Map.Entry<Integer, Integer> firstEntry = map.entrySet().iterator().next(); // 최소값
//                        int key = firstEntry.getKey();
//                        System.out.println(key);
//                        System.out.print("최소값 : ");
                        System.out.println(tMap.get(tMap.firstKey()).first());
                    } else {
//                        keySet.sort(Comparator.reverseOrder());
//                        Map.Entry<Integer, Integer> firstEntry = map.entrySet().iterator().next(); // 최대값
//                        int key = firstEntry.getKey();
//                        System.out.println(firstEntry);
//                        System.out.print("최대값 : ");
                        System.out.println(tMap.get(tMap.lastKey()).last());
                    }
                    break;
                case "add":
                    P = Integer.parseInt(st.nextToken());
                    int L = Integer.parseInt(st.nextToken());
                    hMap.put(P, L);
                    tMap.putIfAbsent(L, new TreeSet<>());
                    tMap.get(L).add(P);
                    break;
                case "solved":
//                    Iterator<Map.Entry<Integer, Integer>> iterator = hMap.entrySet().iterator();
//                    while (iterator.hasNext()) {
//                        Map.Entry<Integer, Integer> entry = iterator.next();
//                        if (entry.getValue().equals(P)) {
//                            iterator.remove();
//                        }
//                    }
                    P = Integer.parseInt(st.nextToken());
                    int level = hMap.get(P);
                    hMap.remove(P);
                    tMap.get(level).remove(P);
                    if (tMap.get(level).isEmpty()) {
                        tMap.remove(level);
                    }
                    break;
            }
        }
    }
}