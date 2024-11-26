import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            문제
            바탕화면에 널부러진 파일들을 확장자 별로 정리한 각각의 개수.
            확장자를 사전 순으로 정렬

            입력 : 첫 번째 줄에 파일의 개수가 주어짐 1이상 50000이하. 아니 어떻게 바탕화면에 파일 5만개가 깔릴 수 있는거지..?
                  두 번째 줄부터 파일의 이름이 영어 소문자 + "." + 확장자명 형태로 주어짐 // 각 파일의 이름 길이는 3이상 100이하.

                  .을 기준으로 잘라내서 해쉬맵에 키 = 확장자명 밸류 = 파일 이름 으로 구분하는게 좋아보임

            출력 : 확장자가 여러 개 있는 경우 확장자 이름의 사전순으로 출력

                  확장자의 첫글자를 뽑아와서 compareTo 돌리면 될 듯?
         */

        int testCases = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hMap = new HashMap<>();
        StringBuilder extension = new StringBuilder();
        for (int i = 0; i < testCases; i++) {
            String line = br.readLine();
//            String line1 = line.split("\\.")[0]; // 파일명은 출력에서 필요한 값이 아님. 카운트만 하면 됨
            String line2 = line.split("\\.")[1];
            // 해쉬 맵의 getOrDefault 사용
            // 맵에 line2가 저장이 안된. 즉 최초 추가시 기본값 0을 주고 +1 해서 카운트 증가
            // 맵에서 line2를 검색해서 있으면 그 값(i)을 가져오고 +1 해서 카운트 증가
            hMap.put(line2, hMap.getOrDefault(line2, 0) + 1);
        }
        List<String> sort = new ArrayList<>(hMap.keySet());
        Collections.sort(sort);

        for (String ex : sort) {
            bw.write(ex + " " + hMap.get(ex));
            bw.newLine();
        }

        bw.flush();
        bw.close();

    }
}