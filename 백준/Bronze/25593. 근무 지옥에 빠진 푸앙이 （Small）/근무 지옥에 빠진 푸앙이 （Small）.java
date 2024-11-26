import java.util.*;import java.io.*;public class Main{
    public static void main(String[] args) throws Exception{Map<String, Integer> m=new HashMap<>();
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        for(int n=Integer.parseInt(r.readLine()),i=1,h;i<= n*4;i++)
            for(String a:r.readLine().split(" "))
                if(!a.equals("-"))m.put(a,m.getOrDefault(a,0)+(h=i%4==1||i%4==3?4:i%4==2?6:10));
        System.out.print(m.isEmpty()||Collections.max(m.values())-Collections.min(m.values())<=12?"Yes":"No");}}