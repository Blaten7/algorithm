/*
# 해석 : N이 홀수일 때,
        1. 산술평균 : N개의 수들의 합을 N으로 나눈 값
        2. 중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
        3. 최빈값 : N개의 수중 개수가 가장 많은 값
        4. 범위 : N개의 수들 중 최댓값과 최소값의 차이
        N이 주어지면 네가지 값을 출력하라

# 입력 :
        Line 1   : N(1 ≤ N ≤ 500,000) N은 홀수
        Line 2 ~ : N개의 줄에 정수 입력되는 정수의 절댓값은 4,000을 넘지 않는다.
        ?? 범위는 50만인데 실질적으로는 4000이라굽쇼?

        아 개수가 50만개고 번위는 4000.
        N도 그 각각의 수가 홀수라는게 아니고 홀수 개라고. 음

# 로직 :
 */

import java.io.*;
import java.util.*;

//Silver3_통계학_2108
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static ArrayList<Integer> statList;

    public static void main(String[] x) throws IOException {
        N = Integer.parseInt(br.readLine());

        statList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            statList.add(Integer.parseInt(br.readLine()));
        }
        double result = 0.0;
        { // N개의 수들의 합을 N으로 나눈 값 소수점 이하 첫째 자리에서 반올림
            for (int a = 0; a < N; a++) {
                result += statList.get(a);
            }
            System.out.println(Math.round(result / N));
        }

        { // N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
            Collections.sort(statList);
            System.out.println(statList.get(statList.size() / 2));
        }

        { // N개의 수들 중 가장 많이 나타나는 값. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값
            Map<Integer, Integer> map = new HashMap<>();
            for (int a = 0; a < N; a++) {
                map.put(statList.get(a), map.getOrDefault(statList.get(a), 0) + 1);
            }
            int X = Collections.max(map.values());
            List<Integer> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == X) {
                    list.add(entry.getKey());
                }
            }
            Collections.sort(list);
            System.out.println(list.size()>1 ? list.get(1) : list.get(0));
        }

        { // N개의 수들 중 최댓값과 최솟값의 차이
            System.out.println(Collections.max(statList) - Collections.min(statList));
        }
    }
}
