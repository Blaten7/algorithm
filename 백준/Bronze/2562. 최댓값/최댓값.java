/*
# 문제 : 정수 9개 입력, 최대값과 인덱스 구하기

# 로직 : 배열 선언하고, 반복문으로 값 넣고, Array.sort 로 맥스값 따내고. 기존배열에서 indexof 사용 인덱스 추적
       - 배열에서 indexof 사용 불가
       - 리소스 신경 안쓰면 리스트로 가능. 아니면 반복문이나 intStream 활용 필요

# 출력 : 최대값"\n"순서

 */
import java.util.*;
interface Main {
    static void main(String[] x) {
        Scanner s = new Scanner(System.in);
        int[] a = new int[9];
        int[] b = new int[9];
        for (int i = 0; i < 9; i++) {
            int c = s.nextInt();
            a[i] = c;
            b[i] = c;
        }
        Arrays.sort(a);
        int len = a.length-1;
        int max = a[len];
        int index = 0;
        for (int i = 0; i <9; i++) {
            if (b[i] == max) {
                index = i+1;
                break;
            }
        }
        System.out.print(max+"\n"+index);
    }
}
