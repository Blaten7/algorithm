
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            문제
            빈 문자열로 시작

            입력 :
                첫 번째 줄 : 버튼을 누른 횟수
                두 번째 줄+ :
                    startWith("1 " + X) = 문자열 뒤에 X 추가
                    startWith("2 " + X) = 문자열 앞에 X 추가
                    startWith("3") = 가장 최근에 추가한 문자 제거

            제한조건 : X는 대, 소문자 둘 다 올 수 있음.

            출력 : 최종 문자열을 출력한다.
         */
        // 키 포인트 : 가장 최근에 추가된 문자열을 어떻게 찾지
        // 스택을 활용. 스택클래스에서 지원하는 기능을 써서 이전작업을 취소 하고
        // 개별 스택에 이전 작업과 현재 작업을 저장해서 경우에 따라 불러오는 스택에 차별성을 두어 롤백구현?

        int btnCount = Integer.parseInt(br.readLine());
//        LinkedList<String> list = new LinkedList<>(); // 배열의 인덱스를 동적으로 저장하기 위한 동적배열 사용
        // 첫번째 요소에 추가가 가능해야 하며 마지막요소를 삭제하는것도 가능하려면 덱을 사용해야 함
        Deque<String> list = new LinkedList<>(); // 현재 상태를 저장.
        Stack<String[]> history = new Stack<>(); // 작업 내역 기록 [작업번호, 값]
        int i = 1;
        boolean flag = false;
        while (btnCount-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
//            if (list.size() > 10 && !a.equals("3")) {
//                list.removeFirst();
//            }
            String how = "";
            switch (a) {
                case "1": // 문자열 뒤에 추가
                    String b = st.nextToken();
                    list.addLast(b); // 현재 상태 저장
                    how = "뒤에 추가";
                    history.push(new String[]{"1", b}); // 작업 기록
                    flag = true;
                    break;
                case "2": // 문자열 앞에 추가
                    String c = st.nextToken();
                    list.addFirst(c);
                    history.push(new String[]{"2", c}); // 작업 기록
                    how = "앞에 추가";
                    flag = false;
                    break;
                case "3": // 가장 최근에 추가된 작업 취소
                    if (!history.isEmpty()) {
                        String[] lastAction = history.pop(); // 최근 작업 가져오기
                        if (lastAction[0].equals("1")) {
                            list.removeLast(); // "뒤에 추가" 작업 취소
                        } else if (lastAction[0].equals("2")) {
                            list.removeFirst(); // "앞에 추가" 작업 취소
                        }
                        how = "최근 작업 취소";
                    }
                    break;
                default:
            }
//            System.out.println(i+"회 실행 결과 : "+how+" : "+list);
            i++;
        }
        if (list.isEmpty()) {
            bw.write("0");
        } else {
            for (String s : list) {
                bw.write(s);
            }
        }

        bw.flush();
        bw.close();
    }
}
