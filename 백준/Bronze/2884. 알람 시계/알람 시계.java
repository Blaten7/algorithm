interface Main {
    static void main(String[] x) {
        var s = new java.util.Scanner(System.in);
        int a = s.nextInt(), b = s.nextInt(), c = a * 60 + b - 45;
        System.out.println(c < 0 ? 23 + " " + (60 + c % 60) : c / 60 + " " + c % 60);
    }
}
