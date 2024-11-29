import java.io.*;

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

# 출력 :
 */

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine()); // toCharArray 사용하면 길이값은 쓸데가 없음. 갖다 버리기 ON
        String input = br.readLine();

        int i = 0;
        int sum = 0;
        for (char c : input.toCharArray()) {
            int num = (c - 'a') +1; // 'a'는 1, 'b'는 2, 'c'는 3으로 변환
            sum += (num * Math.pow(31, i)); // 여긴 왜 int 강제 형변환 해야하는지 전혀 모르겠는데 에러가 뜸 (노란색)
            i++;
        }
        System.out.println(sum);
    }
}