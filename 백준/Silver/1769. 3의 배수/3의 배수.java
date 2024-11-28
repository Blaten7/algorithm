
import java.io.*;

/*
# 문제 해석 :

# 로직 :

# 출력 :
 */

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        int sum = 0, count = 0;
        while (a.length() > 1) {
            sum = 0;
            for (char c : a.toCharArray()) {
                sum += Character.getNumericValue(c);
            }
            a = String.valueOf(sum);
            count++;
        }
        System.out.println(count);
        System.out.print(Integer.parseInt(a) % 3 == 0 ? "YES" : "NO");

    }
}