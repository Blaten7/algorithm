import java.io.*;
import java.util.StringTokenizer;

interface Main {
    static void main(String[] x) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int total = Integer.parseInt(br.readLine());
        int count = Integer.parseInt(br.readLine());
        int result = 0;
        while (count-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            result += Integer.parseInt(st.nextToken())*Integer.parseInt(st.nextToken());
        }
        System.out.println(result==total?"Yes":"No");

    }
}
