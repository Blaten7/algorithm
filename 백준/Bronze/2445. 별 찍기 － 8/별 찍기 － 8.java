
// 1~100까자의 범위중 랜덤 숫자 N을 입력받아서
// 별을 출력하는데. 숫자와 관계없이 최소1개, 최대 N개까지 출력 가능

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a= sc.nextInt();

        // n이 1일때는 행숫자 1, 2일때는 행숫자 3 그 외. 그 이상은 무조건 n+2개의 행 숫자를 지닌다
        // 열의 숫자는 항상 n * 2
        // 제한조건 검증

        if (a<1 || a>100) {
            return;
        }
        // 숫자가 1 또는 2일때 그 외의 로직과 다른 결과값이 도출될 가능성이 존재하며 숫자가 작기때문에 별도의 방식으로 출력

        switch(a) {
            case 1:
                System.out.println("**");
                break;
            case 2:
                System.out.println("*  *");
                System.out.println("****");
                System.out.println("*  *");
                break;
            default: // 3~100까지의 수 해당
                // 1부터 a까지의 행 반복문 안에 대칭선 기준으로 왼쪽과 오른쪽 구분
                for (int i = 1; i <= a; i++) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("*");
                    }

                    for (int j = 1; j <= 2 * (a - i); j++) {
                        System.out.print(" ");
                    }

                    for (int j = 1; j <= i; j++) {
                        System.out.print("*");
                    }

                    System.out.println();
                }

                for (int i = a - 1; i >= 1; i--) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("*");
                    }
                    for (int j = 1; j <= 2 * (a - i); j++) {
                        System.out.print(" ");
                    }
                    for (int j = 1; j <= i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }


        }

    }

}