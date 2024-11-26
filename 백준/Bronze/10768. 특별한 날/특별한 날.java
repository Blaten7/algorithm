interface Main{
    static void main(String[] args){
        var s=new java.util.Scanner(System.in);
        int month = s.nextInt();
        int day = s.nextInt();
        if(month<2)System.out.println("Before");
        else if (month<=2 && day<18)System.out.println("Before");
        else if(month==2&&day==18)System.out.println("Special");
        else System.out.println("After");}}