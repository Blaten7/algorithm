/* 
    총 6자리의 수. 고유값은 5자리 + 검증번호 1자리
    검증번호 : 고유값 각 자리수 제곱의 합을 10으로 나눈 나머지
    
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // int randomNumber = Math.floor(Math.random() * 100000); // 0부터 99999까지의 랜덤 숫자 부여
        // 숫자 랜덤 부여가 아닌 5자리 숫자를 빈칸 하나씩 띄고 입력받음
        
        String randomNumber = scanner.nextLine();
        String rNumString = randomNumber.trim().replace(" ", ""); // 빈칸 제거
        
        // 검증수만 출력하는 건줄 모르고 6자리수를 다 출력하느라 틀렸습니다 6번 봄..
        // 값을 가져오기만 하고 출력을 안해서 7번봄...
        // 다음부터는 문제를 꼼꼼히 잘 읽을 것.
        
        int result = rNumCal(rNumString);
        System.out.println(result);
    }
    
    public static int rNumCal(String rNumString) {
        int a = Integer.parseInt(String.valueOf(rNumString.charAt(0)));
        int b = Integer.parseInt(String.valueOf(rNumString.charAt(1)));
        int c = Integer.parseInt(String.valueOf(rNumString.charAt(2)));
        int d = Integer.parseInt(String.valueOf(rNumString.charAt(3)));
        int e = Integer.parseInt(String.valueOf(rNumString.charAt(4)));
        
    int k = ((a*a)+(b*b)+(c*c)+(d*d)+(e*e))%10;
    
    return k;
}
}

