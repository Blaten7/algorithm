import java.io.*;
import java.util.*;

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        while (a-->0) {
            int b = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            int result = 1;
            while (b-->0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 0) + 1);
            }
            for (int val : map.values()) {
                result *= val+1;
            }
            System.out.println(result-1);
        }
    }
}