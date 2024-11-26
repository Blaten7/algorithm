import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCases = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        while (testCases-- > 0) {
            String input = br.readLine();
            set.add(input);
        }
        List<String> list = new ArrayList<>(set);
        list.sort((s1, s2) -> {
            if (s1.length() != s2.length()) {
                return Integer.compare(s1.length(), s2.length()); // 길이 기준 정렬
            }
            return s1.compareTo(s2); // 사전순 정렬
        });
        for (String word : list) {
            bw.write(word);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

}