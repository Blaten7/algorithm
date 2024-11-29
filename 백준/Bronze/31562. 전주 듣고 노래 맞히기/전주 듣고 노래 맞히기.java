import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
# 문제 해석 : 노래개수와 맞힐노래 개수 받고, 노래 제목이랑 노래 첫음 3자만 저장.
           - 첫 3음만 비교했을 때 같은 값이 있는 제목을 출력,
           - 하나면 노래 제목
           - 둘 이상이면 ?
           - 없으면 !

# 로직 : 2일차까진 문제 딱보면 대충 어떻게 풀어야겠구나 감이 왔는데
        3일차부턴 직관이 미국갔나봄. 해시를 사용한 집홥과 맵으로 분류가 되있으니 그걸로
        각 제목의 첫음절 3자를 키로 사용,
        중복된 값이 없으면 제목을 저장하고, 중복된 값이 있으면 ?을 저장
        없을때 ! 말고는 그냥 제목출력하면 알아서 잘 되게 해볼생각

# 출력 : 한줄에 하나씩 줄바꿈해서 출력
 */

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();
        StringBuilder songNote = new StringBuilder();

        while (a--> 0) {
            songNote = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // 제목 길이 갖다 버리기
            String songTitle = st.nextToken(); // 제목
            for (int i = 0; i < 3; i++) {
                songNote.append(st.nextToken());
            }
            map.put(songNote.toString(), map.containsKey(songNote.toString()) ? "?" : songTitle); // 중복값인 경우 ?로 저장
        }

        while (b-- > 0) {
            String note = br.readLine().replaceAll("\\s", "");
            System.out.println(map.get(note) != null ? map.get(note) : "!"); // 이런 음으로 시작하는 제목이 없으면 !, 있으면 제목
        }



    }
}