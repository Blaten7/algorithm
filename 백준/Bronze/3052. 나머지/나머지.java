import java.io.*;
import java.util.HashSet;

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            int a = Integer.parseInt(br.readLine());
            set.add(a%42);
        }
        System.out.print(set.size());

    }
}