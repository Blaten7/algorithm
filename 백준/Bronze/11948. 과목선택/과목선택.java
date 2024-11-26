import java.util.*;

interface Main{static void main(String[]x){
    var s=new java.util.Scanner(System.in);
    List<Integer> l=new ArrayList<>();
    int r=0;
    for (;r<4;r++)l.add(s.nextInt());
    Collections.sort(l);
    l.remove(0);
    r=0;
    for(int n:l)r+=n;
    System.out.println(r+Math.max(s.nextInt(),s.nextInt()));}}
