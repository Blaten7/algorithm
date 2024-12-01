import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
# 문제 : 올해의 양조장 [브론즈 1] 11557

# 해석 : 술 소비량이 가장 많은 학교 이름을 출력
        Line 1 : 테스트 케이스 숫자

        테스트 케이스 별 Line 1 : 1이상 100이하 학교 숫자
                       Line 2 : 길이 1이상 20이하 학교이름 + 0이상 천만이하 술 소비량

# 로직 : 트리맵 사용, 역정렬하고 최대값 벨류 출력

# 이슈 :
 */

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<Integer, String> tMap = new TreeMap<>();

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int schoolNum = Integer.parseInt(br.readLine());
            while (schoolNum-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String schoolName = st.nextToken();
                int drink = Integer.parseInt(st.nextToken());
                tMap.put(drink, schoolName);
            }
            System.out.println(tMap.get(tMap.lastKey()));
        }
    }
}