import java.io.*;

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] a = br.readLine().split("");
        int b = Integer.parseInt(br.readLine());

        System.out.print(a[b-1]);
    }
}