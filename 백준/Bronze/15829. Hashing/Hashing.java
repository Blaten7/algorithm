import java.io.*;
import java.math.BigInteger;

/*
# 문제 해석 : 음.. 저게 시그마처럼 생긴건 알겠는데 ㅋㅋ
           - 입력은 영문 소문자만
           - 각 알파벳에 고유번호 부여 가능
           - 문자열을 수열로 변경 가능 - > abab == 1 2 2 1
           - 해시값 계산의 목적
           - 서로소는 또 뭐람, 대충 알긴 아는데 말로 설명을 못하면 모르는 거지 뭐..

# 로직 : 일단 아스키코드로 문자 를 숫자로 변환 사용.
      - 입력받은 문자열을 한자씩 쪼개서 숫자로 바꿈. // abcde - > 12345
      - 그다음에 계산.


# 이슈 :
        - 문제 1 []
        - 부분성공.
        - Small - > 정상 처리
        - Large - > 에러 발생.
        - Math.pow()가 기본적으로 double 이니 합계 값 또한 double 타입으로 바꾸어 시도.
        - long - > 50점..
        - BigInteger 타입과 BigInteger.multiply, BigInteger.pow - > 50점
        - 이유가 뭘까?
        - 그래도 50점.
 */

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine()); // toCharArray 사용하면 길이값은 쓸데가 없음. 갖다 버리기 ON
        String input = br.readLine();

        int i = 0;
        BigInteger sum = BigInteger.ZERO;
        for (char c : input.toCharArray()) {
            int num = (c - 'a') +1; // 'a'는 1, 'b'는 2, 'c'는 3으로 변환
            BigInteger term = BigInteger.valueOf(num).multiply(BigInteger.valueOf(31).pow(i));
            sum = sum.add(term).mod(BigInteger.valueOf(1234567891));
            i++;
        }
        System.out.println(sum);
    }
}