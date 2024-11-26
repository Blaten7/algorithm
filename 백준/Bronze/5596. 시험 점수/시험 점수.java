interface Main {
    static void main(String[] x) {
        var s = new java.util.Scanner(System.in);
        int a = 0, b = 0;
        for (int i=1;i<9;i++) {
            if (i<5)a+=s.nextInt();
            else b+=s.nextInt();
        }
        System.out.println(Math.max(a, b));
    }
}