import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (b--> 0) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st1.nextToken());
            int d = Integer.parseInt(st1.nextToken());
            int e = Integer.parseInt(st1.nextToken());
            for (; c<=d;c++) {
                map.put(c, e);
            }
        }
        int i = 1;

        while (a--> 0) {
            System.out.print(map.get(i) != null ? map.get(i) + " " : 0 + " ");
            i++;
        }
    }
}