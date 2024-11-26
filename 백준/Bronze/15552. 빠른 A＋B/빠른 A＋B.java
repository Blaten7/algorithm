import java.io.*;
import java.util.*;

interface Main {
    static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            bw.write(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())+"\n");
        }
        bw.flush();
    }
}

