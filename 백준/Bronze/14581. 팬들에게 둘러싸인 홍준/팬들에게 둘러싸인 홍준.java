interface Main {
    static void main(String[] args) {
        var s = new java.util.Scanner(System.in);
        System.out.println(":fan:".repeat(3));
        System.out.println(":fan::"+s.nextLine()+"::fan:");
        System.out.println(":fan:".repeat(3));
    }
}