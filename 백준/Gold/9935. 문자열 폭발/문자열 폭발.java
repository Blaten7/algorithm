/*
# 문제 해석 : 특정 문자열 삭제, 최종 문자열 출력

# 로직 : replaceAll 사용

# 출력 : 최종 문자열
 */

import java.io.*;

public class Main {
    public static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        String explosion = br.readLine();
/*

        while (line.contains(explosion)) {
            line = line.replaceAll(explosion, "");
        }
        // 메모리 초과 이슈 발생.
        -> 추정 원인 1, while 사용 = 문자열 길이가 최대 백만. 매번 반복하며 하나하나 훑어서
        -> 추정 원인 2, replaceAll 사용 = 폭발문자열이 있을 때 마다 새로운 문자열을 생성해서

        -> 해결 방안 1, 스트링빌더 활용, 문자열을 문자로 쪼개서 하나하나 추가.
        ->           ; 만들어지고 있는 빌더의 끝 문자가 폭발문자와 일치한다면 제거,
        ->           ; 다음루프 이동
 */
        StringBuilder result = new StringBuilder();
        int len = explosion.length(); // 인덱스 추적을 위한 길이값 추출
        for (char c : line.toCharArray()) {
            result.append(c); // 일단 추가 하고 보기
            int bombIndex = result.length() - len; // 폭발 문자열을 추출하기 위한 인덱스 계산
            // 일단 전체 문자열의 길이가 폭발문자열보단 커야함. 그리고 뒤에서 부터 문자열 길이까지 뺀 값이 폭발문자열과 같을 때
            if (result.length() >= len && result.substring(result.length() - len).equals(explosion)) {
                result.delete(result.length() - len, result.length()); // 폭발물 있으면 제거
            }
        }
        bw.write(result.length() == 0 ?"FRULA":result.toString());
        bw.flush();
    }
}