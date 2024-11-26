import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
            문제
            첫 줄에 서로 다른 세자리수가 주어짐.
            상수 머리가 잘못되가지고 숫자를 뒤집어서 읽음
            ex) 734를 437로 읽는 아주 불쌍한 친구.
            이렇게 각각 뒤집어서 비교할것.
         */
        String a = st.nextToken(); // 각각 받아서
        String b = st.nextToken();
        StringBuilder A = new StringBuilder(a); // 스트링빌더로 만들고
        StringBuilder B = new StringBuilder(b);
        System.out.println(Math.max(Integer.parseInt(A.reverse().toString()), Integer.parseInt(B.reverse().toString()))); // 뒤집어서 숫자로 변환한다음 큰값 비교

    }
}