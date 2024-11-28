
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
# 문제 해석 : 입력받은 단어중 뒤집었을때 일치하는 문자가 비밀번호.
           - 비밀번호는 항상 홀수의 길이를 가짐.
           - 해당 비밀번호의 길이와 가운데 글자를 공백구분 한줄 출력

# 로직 : 입력받은 단어를 어딘가에 저장. 단어를 하나하나 뒤집어서 매치시키고 매치 되는게 있으면 그놈이 범인

# 출력 :
 */

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        while (testCase-- > 0) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            map.put(line, 0);
            map2.put(String.valueOf(sb.append(line).reverse()), 0);
        }
        String pw = "";
        for (String key : map.keySet()) {
            for (String key2 : map2.keySet()) {
                if (key.equals(key2)) {
                    pw = key;
                }
            }
        }
        System.out.print(pw.length() + " " + pw.charAt((pw.length() - 1)/2));

    }
}