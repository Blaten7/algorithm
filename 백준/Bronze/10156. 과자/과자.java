interface Main {
    static void main(String[] x) {
        var s = new java.util.Scanner(System.in);
        int a=s.nextInt()*s.nextInt()-s.nextInt();
        System.out.println(a>0?a:0);
    }
}