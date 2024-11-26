import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double n = sc.nextDouble();
		double total;
		
		while(n != 0) {
			total = 0;
			total += n;
			total += n * n;
			total += n * n * n;
			total += n * n * n * n;
			total += 1;
			System.out.println(String.format("%.2f", total));
			n = sc.nextDouble();
		}
		sc.close();
	}
}