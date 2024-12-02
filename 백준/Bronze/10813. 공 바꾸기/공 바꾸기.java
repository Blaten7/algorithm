
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= a; i++) {
            map.put(i, i);
        }

        int b = Integer.parseInt(st.nextToken());
        while (b--> 0) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st1.nextToken());
            int d = Integer.parseInt(st1.nextToken());
            int cTemp = map.get(c);
            int dTemp = map.get(d);
            map.put(d, cTemp);
            map.put(c, dTemp);
        }
        int i = 1;
        while (a--> 0) {
            System.out.print(map.get(i) != null ? map.get(i) + " " : 0 + " ");
            i++;
        }
    }
}