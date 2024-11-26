import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        /*
            문제
            칸토어 집합 : 0 ~ 1 사이의 실수 로 이루어진 집합
            구간 [0, 1]에서 시작해서 각 구간을 3등분 ?? 이게 뭔소리지
            아무튼 그래서 가운데 구간을 삭제.

            전체 집합이 유한이라고 가정? 그러면 제한조건을 줘야 하는거 아닌가요 선생님

            1. -가 3^N개 있는 문자열에서 시작한다.
            2. 문자열을 3등분 한 뒤, 가운데 문자열을 공백으로 바꾼다. 이렇게 하면, 선(문자열) 2개가 남는다.
            3. 이제 각 선(문자열)을 3등분 하고, 가운데 문자열을 공백으로 바꾼다. 이 과정은 모든 선의 길이가 1일때 까지 계속 한다.

            집합의 개수를 한정 짓기 위해 세제곱^정수로 그리고 계산하기 편하게 문자열은 -로 통일

         */
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int a = Integer.parseInt(line.trim()); // 각 줄의 입력을 정수로 변환
            int cal = 1;
            for (int j = 0; j < a; j++) { // 받은 정수를 3의 N제곱으로 변경
                cal *= 3;
            }
            String b = "-".repeat(cal); // 정수값을 - 형태로 길이 맞춰서 바꿔줌
            String result = cantorSet(b); // 재귀 호출
            bw.write(result);
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }

    private static String cantorSet(String a) throws IOException {
        if (a.length() < 3) { // 종료 조건: 문자열 길이가 1인 경우
            return a;
        }
        int c = a.length()/3; // 문자열을 나눌 길이
        String left = a.substring(0,c);
        String blank = " ".repeat(c);
        String right = a.substring(c, c*2);

        return cantorSet(left) + blank + cantorSet(right);

    }
}
