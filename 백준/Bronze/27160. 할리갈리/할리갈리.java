import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            문제
            딸기, 바나나, 라임, 자두가 최소1, 최대5개 그려진 카드 4종

            입력 :
                첫 번째 줄 : 총 카드의 개수가 주어짐 ex)3
                바나나 2,
                자두 4
                바나나 3
                이렇게 주어지면 YES출력
         */
        int cardCount = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        while (cardCount-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String fruitName = st.nextToken();
            int fruitCount = Integer.parseInt(st.nextToken());
            map.put(fruitName, map.getOrDefault(fruitName, 0) + fruitCount); // 이름이 같으면 갯수만 추가
        }
        if (map.containsValue(5)) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        bw.flush();
        bw.close();
    }
}
