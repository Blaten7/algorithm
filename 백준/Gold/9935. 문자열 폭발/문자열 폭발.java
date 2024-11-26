import java.util.Scanner;

interface Main {
    static void main(String[] x) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int c = b.length();
        StringBuilder r = new StringBuilder();
        int k=r.length();
        for (char d : a.toCharArray()) {
            r.append(d);
            if (r.length() >= c &&
                    r.substring(r.length() - c).equals(b)) {
                r.delete(r.length() - c, r.length());}}System.out.println(r.length()>0?r:"FRULA");}}