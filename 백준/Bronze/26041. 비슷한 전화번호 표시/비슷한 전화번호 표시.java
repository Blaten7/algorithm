import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        /*
            입력조건 :
                라인 1 : 1에서 10만개 사이의
                    2에서 100만의 길이를 갖는 문자열 A를 받음
                라인 2 : 2이상 10이하의 접두사 문자열 B를 받음

            출력 : B로 시작하는 A 문자열의 개수를 찾기.
            제한조건 : B와 A가 동일하면 제외.
         */
        // 문자열을 배열에 계속 집어넣다가 다음이 없을때 마지막 문자열을 따로 저장.
        StringBuilder A = new StringBuilder();
        while (st.hasMoreTokens()) { // 다음 토큰의 검증을 중첩으로 해서 있으면 A에 저장, 없으면 B에 저장.
            A.append(st.nextToken()).append(" ");
//            else {
//                B = st.nextToken();
//                System.out.println("B를 찾을 수 있기는 해?");
//            }
        } // 입력받은 문자열에서 A와 B를 구분해 저장 완료
//        String lastToken = A.toString().trim(); // 전체를 문자열로 변환 후 양끝 공백 제거
//        String[] tokens = lastToken.split(" "); // 공백 기준으로 분리
//        String B = tokens[tokens.length - 1]; // 마지막 토큰
        String B = br.readLine();

        int result = compareAwithB(A, B);
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static int compareAwithB(StringBuilder a, String b) {
        StringTokenizer A = new StringTokenizer(a.toString());
        int count = 0;
        while (A.hasMoreTokens()) {
            String token = A.nextToken();
            if (token.startsWith(b) && !token.equals(b)) {
                count++;
            }
        }
        return count;

    }


}