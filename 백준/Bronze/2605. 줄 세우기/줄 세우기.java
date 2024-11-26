import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
            문제

            매일 앞자리에 앉는 학생이 먼저먹고, 뒷자리는 나중에 먹음.
            이를 해결하기 위해 기존 줄에서 1번부터 번호를 뽑음.

            첫번째 제비는 0만 가능.
            두번째 제비는 0또는 1을 받아 1뽑으면 젤 앞에 감
            세번째 제비는 0, 1, 2중 하나를 뽑아 그 수만큼 앞으로 이동
            각자 뽑을 수 있는 번호의 스펙트럼은 본인 인덱스 - 1 의 수열

            입력 :
            첫 줄에 학생 수가 주어짐
            두 번째 줄에 학생들이 뽑은 번호가 주어짐.

            제한 : 학생은 100이하, 제비는 0과 자연수

            출력 : 최종적으로 학생들이 서 있는 순서를 공백으로 구분하여 한줄로 나열

            중간 삽입/삭제가 많다: LinkedList가 적합.
            빠른 데이터 접근이 필요하다: ArrayList를 고려.
            양 끝에서만 삽입/삭제: ArrayDeque를 사용.
            우선순위가 필요: PriorityQueue를 사용.
            스택/큐와 같은 동작 필요: Stack 또는 Deque를 사용.
         */

        int student = Integer.parseInt(br.readLine()); // 학생 수
        String[] drawLine = br.readLine().split(" "); // 학생들이 뽑은 번호

        LinkedList<Integer> students = new LinkedList<>(); // 학생 순서

        for (int i = 0; i < student; i++) {
            int currentStudent = i + 1; // 현재 학생 번호
            int draw = Integer.parseInt(drawLine[i]); // 학생이 뽑은 번호
            students.add(students.size() - draw, currentStudent); // 뽑은 번호만큼 앞으로 이동
        }

        // 출력
        for (int studentNum : students) {
            bw.write(studentNum + " ");
        }

        bw.flush();
        bw.close();
    }
}
