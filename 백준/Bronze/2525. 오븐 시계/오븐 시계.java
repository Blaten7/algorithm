interface Main {
    static void main(String[] x) {
        var s = new java.util.Scanner(System.in);
        int a = s.nextInt(), b = s.nextInt(), c = s.nextInt(), d = a * 60 + b + c;
        System.out.print(d / 60 >= 24 ? (d / 60 - 24) + " " + (d % 60) : d / 60 + " " + (d % 60));
    }
}
