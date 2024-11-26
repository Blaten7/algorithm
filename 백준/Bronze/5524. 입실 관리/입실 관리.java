interface Main{
    static void main(String[] args){
        var s=new java.util.Scanner(System.in);
        int a=Integer.parseInt(s.next()),i=0;
        for(;i<a;i++) {
            System.out.println(s.next().toLowerCase());
        }
        
    }
}