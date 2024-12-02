import java.io.*;

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        for (int i = 0; i < a; i++) {
            System.out.print("*");
            for (int j = 0; j < b-1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}