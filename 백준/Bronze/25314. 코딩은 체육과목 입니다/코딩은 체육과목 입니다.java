/*
# 문제 : 숫자 4당 1개의 long

# 입력 : 정수값

# 로직 : 입력받은 값 n/4.repeat

 */
interface Main {
    static void main(String[] x) {
        var s = new java.util.Scanner(System.in);
        System.out.println("long ".repeat(s.nextInt()/4)+"int");
    }
}
