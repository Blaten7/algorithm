interface Main{static void main(String[]x){var s=new java.util.Scanner(System.in);int a=s.nextInt(),n=s.nextInt(),c=n,i=3;for(;i-->0;n/=10)System.out.println(a*(n%10));System.out.print(a*c);}}