import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toUpperCase(); // 대소문자 구분하지 않기 위해 대문자로 변환
        int[] frequency = new int[26]; // 알파벳 빈도 수 저장 (A-Z)

        // 빈도 계산
        for (char ch : input.toCharArray()) {
            frequency[ch - 'A']++;
        }

        // 최댓값 찾기
        int maxFrequency = -1;
        char result = '?';
        for (int i = 0; i < 26; i++) {
            if (frequency[i] > maxFrequency) {
                maxFrequency = frequency[i];
                result = (char) (i + 'A'); // 해당 알파벳
            } else if (frequency[i] == maxFrequency) {
                result = '?'; // 최대값이 여러 개인 경우
            }
        }

        // 출력
        System.out.println(result);
    }
}
