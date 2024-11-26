import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        /*
            문제
            입력받은 문자열 S의 서로 다른 부분 문자열의 개수를 구하는 프로그램
            ex) ababc 의 서로 다른 부분 문자열의 개수는 12개이다.

            입력 : 첫 줄에 문자열 하나가 주어짐. 1이상 1000이하

            출력 : 서로 다른 부분 문자열의 개수를 출력

         */
        String test = sc.nextLine();
        // for 중첩문으로 i, j의 값을 증가시켜 나가며 해당 값으로 문자열을 substring 하고
        // 그 결과값이 원래의 문자열에 포함되는지. contains 를 사용해 검증.
        // 그리고 카운트 증가시켜서 출력.
        // ========================================================================
        // 틀림 이건 한글자씩 만 찾는거라고 결과값이 기댓값과 상이함.
        // 아닌데.. 그건 반복문 하나 일때고 중첩이면 상관 없지 않나?
        // 내부 반복문 조건 설정에 사소한 오류가 있었음. 해결했고 다음.
        // 단순히 잘라낸 문자열이 원래 문자열에 포함되는지 검증 하는 것 뿐만 아니라.
        // 이전에 저장된 문자열과 비교해서 같은게 있는지 없는지 확인하는 로직 하나 추가하면 끝

        int count = 0;
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < test.length(); i++) {
//            for (int j = i + 1; j <= test.length(); j++) { // sb에 추가하고 비교하고 어쩌구 저쩌구 했는데 그냥 set 에 저장하면 중복값은 무시되니까 set 으로 저장
//                String sub = test.substring(i, j);
//                boolean result = sb.equals(sub);
//                System.out.println("result = " + result);
//                if (result) {
//                    System.out.println("추가함");
//                    sb.append(sub).append(" ");
//                    if (test.contains(sub)) {
//                        count++;
//                    }
//                }
//
//            }
//        }
        HashSet<String> hSet = new HashSet<>();
        for (int i = 0; i < test.length(); i++) {
            for (int j = i + 1; j <= test.length(); j++) {
                String sub = test.substring(i, j);
                hSet.add(sub);
            }
        }
        System.out.println(hSet.size());
    }

}
