import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
            문제
            영문 대소문자 및 공백으로 이루어진 문자열을 입력받음.
            이 문장에 몇개의 단어가 있는 지 구하는 프로그램.
            이게 브론즈2..? 이건 아이언 5같은데 이게 왜 정답률이 33%.......???????
         */
        int count = 0;
        while (st.hasMoreTokens()) {
            st.nextToken();
            count++;
        }
        System.out.println(count);
    }
}