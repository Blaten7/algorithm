interface Main{static void main(String[]x){var s=new java.util.Scanner(System.in);int z=0,m[]={1440,60,1};for(int i=0;i<3;i++)z+=s.nextInt()*m[i];System.out.print(Math.max(z-16511,-1));}}