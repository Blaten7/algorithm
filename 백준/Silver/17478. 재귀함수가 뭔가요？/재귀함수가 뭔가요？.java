import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
            문제 설명 : TMI 5줄

            입력 조건 : 1이상 50이하의 재귀횟수 N이 주어짐

            출력조건 : 재귀 횟수에 따른 AI의 응답을 출력

            제한조건 : 그런거 없음

            뭐 수능국어영역 지문인가

         */
        int n = Integer.parseInt(st.nextToken());
        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다." + "\n"); // 최초 1회 실행
        printf(n, 0);
        bw.flush();
        bw.close();

    }

    private static void printf(int a, int count) throws IOException {
        String blank = "____".repeat(count);
        bw.write(blank + "\"재귀함수가 뭔가요?\"" + "\n");

        if (a == count) {
            bw.write(blank + "\"재귀함수는 자기 자신을 호출하는 함수라네\"" + "\n");
            bw.write(blank + "라고 답변하였지." + "\n");
            return;
        }
        bw.write(blank + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어." + "\n");
        bw.write(blank + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지." + "\n");
        bw.write(blank + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"" + "\n");
        printf(a, count+1);

        bw.write(blank + "라고 답변하였지." + "\n");
    }

}
