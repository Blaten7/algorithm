interface Main{
    static void main(String[] args){
        var s=new java.util.Scanner(System.in);
        int b=0;
        for(;s.hasNext();) {
            int a=s.nextInt();
            if(a<40)a=40;
            b+=a;
        }
        System.out.print(b/5);
    }
}