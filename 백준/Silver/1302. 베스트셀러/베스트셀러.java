import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        /*
            문제

            첫 번째 줄에 오늘 팔린 책의 개수 N 최소 1 최대 1000
            두 번째 줄 부터 N개의 줄에 책의 제목이 입력됨 제목의 길이는 50이하.

            출력 : 가장 많이 팔린 책의 제목을 출력.
            제한조건 : 공동1위가 있을 경우, 사전순으로 앞서는 제목을 출력
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> map = new HashMap<>();
        int soldCount = Integer.parseInt(br.readLine());

        while (soldCount-- > 0) { // 0 이 될 때까지 1씩 감소, 0이면 루프 종료
            String bookTitle = br.readLine();
            map.put(bookTitle, map.getOrDefault(bookTitle, 0) + 1); // 이름이 같은 책끼리 카운트 +1
        }

        int maxSales = Collections.max(map.values()); // 최고 판매량이 몇개인가용?

        List<String> bestSeller = new ArrayList<>();
        for (String key : map.keySet()) { // 책이름에 해당하는 판매량값을 뽑아내서 그게 최고판매량하고 똑같으면 베스트셀러 목록에 저장
            if (map.get(key) == maxSales) {
                bestSeller.add(key);
            }
        }

        Collections.sort(bestSeller); // 저장된 베스트셀러 목록을 사전순으로 정렬

        bw.write(bestSeller.get(0)); // 제일 첫번째가... 단어가 생각이 안나는데 아무튼 얘가 맞는 거
        bw.flush();
        bw.close();


    }
}