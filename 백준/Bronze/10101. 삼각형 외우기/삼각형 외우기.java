interface Main{static void main(String[]x){var s=new java.util.Scanner(System.in);int a=s.nextInt(),b=s.nextInt(),c=s.nextInt();System.out.print(a+b+c!=180?"Error":a==60&b==60&c==60?"Equilateral":a==b|b==c|a==c?"Isosceles":"Scalene");}}