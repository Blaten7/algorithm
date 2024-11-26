import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger n = new BigInteger(br.readLine());
        BigInteger m = new BigInteger(br.readLine());
        System.out.println(n.add(m)+"\n"+n.subtract(m)+"\n"+n.multiply(m));
        
    }
    
}
