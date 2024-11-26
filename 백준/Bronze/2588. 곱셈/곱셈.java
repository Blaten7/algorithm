interface Main {
    static void main(String[] x) {
        var s = new java.util.Scanner(System.in);
        int a = s.nextInt(), b[] = new int[3], i = 2, n = s.nextInt(), c = n;
        for (; i >= 0; i--) {
            b[i] = n % 10;
            n /= 10;
        }
        for (i=2; i >=0; i--) {
            System.out.println(a*b[i]);
        }
        System.out.print(a*c);
    }
}