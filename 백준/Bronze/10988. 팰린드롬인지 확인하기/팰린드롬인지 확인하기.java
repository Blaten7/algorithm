import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        sb.append(line).reverse();
        if (line.contentEquals(sb)) {
            System.out.print(1);
        }else {
            System.out.print(0);
        }
    }
}