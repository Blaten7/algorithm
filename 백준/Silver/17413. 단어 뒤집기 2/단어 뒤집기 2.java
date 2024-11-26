import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            문제
            첫 줄에 문자열을 입력받아 각각의 태그 내부/외부 문자열을 구분
            태그 외부 문자열은 뒤집어서 출력, 내부는 그대로 유지
         */

        String input = br.readLine(); // 입력 문자열
        StringBuilder result = new StringBuilder();

        // 태그 내부 여부 체크
        boolean insideTag = false;
        StringBuilder temp = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (ch == '<') {
                // 태그 외부 문자열 처리
                if (!insideTag && temp.length() > 0) {
                    result.append(temp.reverse()); // 외부 문자열 뒤집기
                    temp.setLength(0); // 초기화
                }
                temp.append(ch); // 태그 시작
                insideTag = true;
            } else if (ch == '>') {
                temp.append(ch); // 태그 종료
                result.append(temp); // 태그 문자열 추가
                temp.setLength(0); // 초기화
                insideTag = false;
            } else if (ch == ' ' && !insideTag) {
                // 공백일 때, 태그 외부 문자열 처리
                result.append(temp.reverse()).append(" "); // 외부 문자열 뒤집기 후 공백 추가
                temp.setLength(0); // 초기화
            } else {
                temp.append(ch); // 일반 문자 추가
            }
        }

        // 남은 문자열 처리
        if (temp.length() > 0) {
            if (insideTag) {
                result.append(temp); // 태그 내부 그대로 추가
            } else {
                result.append(temp.reverse()); // 외부 문자열 뒤집기
            }
        }

        // 결과 출력
        bw.write(result.toString());
        bw.flush();
        bw.close();
    }
}
