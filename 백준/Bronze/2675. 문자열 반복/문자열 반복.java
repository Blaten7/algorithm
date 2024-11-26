import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
            문제
            문자열 S를 입력받은 후에 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력 할 것.
            ex) 첫 번째 문자를 R번 + 두 번째 문자를 R번 + ......

            입력: 라인1에 테스트 횟수, 라인2에 반복횟수와 문자열 공백기준.

            제한조건 : 테스트횟수는 1이상 1000이하. 문자열길이는 1이상 20이하
         */
        int testCase = Integer.parseInt(st.nextToken()); // 테스트 횟수

        for (int i = 0; i < testCase; i++) {
            st = new StringTokenizer(br.readLine()); 
            int repeatCount = Integer.parseInt(st.nextToken()); // 반복 횟수
            String repeatString = st.nextToken(); // 반복할 문자열

            String result = makeRepeatString(repeatCount, repeatString);
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static String makeRepeatString(int repeatCount, String repeatString) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < repeatString.length(); i++) {
            result.append(String.valueOf(repeatString.charAt(i)).repeat(repeatCount)); // 문자열 인덱스로 뽑아 낸 후 반복횟수만큼 반복하여 결과 문자열에 추가
        }
        return result.toString();
    }
}