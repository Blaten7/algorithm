import java.io.*;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = 3;
        TreeMap<Integer, String> map = new TreeMap<>();
        while (test-- >0) {
            int a = Integer.parseInt(br.readLine());
            map.put(a, "a");
        }
        map.remove(map.firstKey());
        map.remove(map.lastKey());
        System.out.println(map.firstKey());
    }
}
