import java.util.*;

interface Main{static void main(String[]x){
    var s=new java.util.Scanner(System.in);
    List<Integer> list = new ArrayList<>();
    list.add(s.nextInt());
    list.add(s.nextInt());
    list.add(s.nextInt());
    list.add(s.nextInt());
    Collections.sort(list);
    list.remove(0);
    System.out.println(list.get(0)+list.get(1)+list.get(2)+Math.max(s.nextInt(),s.nextInt()));
}
}


