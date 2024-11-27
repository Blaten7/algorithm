
import java.io.*;
import java.util.*;

/*
# 문제 해석 : A와 B로만 이루어진 N개의 문자열에서 같은 문자열끼리 선을 그었을 때 겹치지 않는 문자열의 개수를 구하시오

# 로직 :
        1. A, B가 짝이 맞지 않을 때 건너뛰기
        2. 확실하진 않지만 문자열에서 좋은 단어를 이루는 구성인 선. 을 긋는 각 문자의 인덱스 합계 값이 홀수.
         - 합계 값이 짝수가 나오면 건너 뛰기
        3. 일단 위의 조건을 다 통과하면 1개 추가하고 테스트 해보기

# 출력 : 총 개수 출력

 */
interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
/*        int tracking = 1;
        int testCases = Integer.parseInt(br.readLine());
        int result = 0;
        while (testCases-- > 0) {
            String str = br.readLine();

                A또는 B의 짝이 맞지 않을 때
                if (str.replace("A","").length() != str.replace("B","").length()) {
                - 원래 이조건인데. 예제 3번의 결과값에 오류가 있어 확인해보니
                - A쌍과 B쌍이 같아야 하는 잘못된 조건.
                - A와 B쌍 모두 %2==0 으로 변경 요망

            if (str.replace("A", "").length() % 2 == 0 && str.replace("B", "").length() % 2 == 0) {
                System.out.println(tracking+"번째 문장, 조건 1 통과");
                int indexA = 0, indexB = 0;
                int[] indexSetA = new int[str.length()], indexSetB = new int[str.length()];
                int indexSetResultA = 0, indexSetResultB = 0;
                for (char c : str.toCharArray()) {
                    if (c == 'A') {
                        indexSetA[indexA] = indexA;
                    }
                    indexA++;
                }
                for (char c : str.toCharArray()) {
                    if (c == 'B') {
                        indexSetB[indexB] = indexB;
                    }
                    indexB++;
                }
                for (int i = 0; i < indexSetA.length; i++) {
                    indexSetResultA += indexSetA[i];
                }
                for (int i = 0; i < indexSetB.length; i++) {
                    indexSetResultB += indexSetB[i];
                }
                if (indexSetResultA % 2 != 0 || indexSetResultB % 2 != 0) { // 둘다 인덱스 합이 홀수일때
                    // B값이 없을때 에러나는 것으로 추정. && -> || 변경
                    System.out.println(tracking+"번째 문장, 조건 2 통과");
                    result++;
                }
            }
            tracking++;
        }
        System.out.println(result);

            - 예제는 다 처리가 되는데 틀렸다고 나와서 여러 조건 검증해보고 했는데도 틀림.
            - GPT 에 코드 올리고 반례를 찾아도 제대로 된게 나오질 않음
            - 유료버전인데도 성능 수준이 내 취업에 영향을 미칠 것 같지 않으니 긍정적 ㅎ
            - 구글링 하다가 이 문제를 푸려면 스택 구조를 활용해야 한다는 키워드 접수.
            - 역시 9textRingXGhostLife
            - 스택에 문자 집어넣고, 다음 문자가 이전 문자랑 같으면 쌍으로 제거. 반복해서 스택에 값이 없으면 좋은단어.
    */

        int testCases = Integer.parseInt(br.readLine());
        int r = 0, k = 1;
        while (testCases-- > 0) {
            Stack<String> result = new Stack<>(); // 스택 선언
            String str = br.readLine(); // N번째 문자열
            for (char c : str.toCharArray()) { // 문자열을 문자로 쪼개고
                if (result.empty()) {
                    result.push(String.valueOf(c)); // 첫번째 반복인경우 조건없이 추가
//                    System.out.println("첫 번째 값 추가"+result);
                } else if (!result.isEmpty()) { // 첫번째가 아니고 스택이 비어있지 않은 경우.
                                                // 이해가 안되는 게 하나 있는데 스택이 비어있을 수 없는 조건들을 상단에 설정을 해놨어도
                                                // pop 을 실행하는 단 바로 상위에 해당 조건이 추가가 안되면 EmptyStack 에러가 발생함.
                                                // ?????????????????????????????????? 왜 그러는지 진짜 모름 그냥 그런가보다 하는중
//                    System.out.println("=========스택에 값있음===========");
                    String compare = result.pop();
                    /*
                        pop 을 실행하는 순간 값을 꺼내오고 스택에서 삭제함.
                        if (!compare.equals(String.valueOf(c))) 꺼내온 값과 지금 문자가 같지 않으면.
                        꺼내온값 다시 넣고, 지금 값도 추가해.

                        반대로 꺼내온값과 지금 문자가 같아.
                        그러면 꺼내온값은 별도 처리 없이 이미 삭제가 되었고, 지금 문자도 추가를 안해.
                        근데 어떻게 쳐 남아 있냐고

                        나는 병신인가?
                        스택에 첫번째 추가하는 로직이 잘못됨.
                        int count ++ 해서 0일때 하고 있었는데
                        size 또는 empty 로 계산아 맞는거지.... 멍청아
                     */
                    if (!compare.equals(String.valueOf(c))) {
//                        System.out.println("이전과 지금 같지 않음");
//                        System.out.println("꺼내온 값 : "+compare);
//                        System.out.println("현재 스택 : " +result);
                        result.push(compare);
//                        System.out.println("꺼내온값 다시 추가후 스택 : " +result);
                        result.push(String.valueOf(c));
//                        System.out.println("현재값 추가후 스택 : " +result);
                    } else {
//                        System.out.println("이전과 지금 같음 그러니까 꺼내온값 추가도 안하고 지금값도 추가 안함");
                    }

                }
            }
//            System.out.println("==================================================="+k+"회 결과"+result);
            k++;
            if (result.isEmpty()) {
                r++;
            }
        }
        System.out.println(r);

    }
}