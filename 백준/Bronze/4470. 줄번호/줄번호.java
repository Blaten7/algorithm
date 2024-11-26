import java.util.Scanner;

interface Main{
    static void main(String[]x){
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        for(int i=1;i<a+1;i++){
            System.out.println(i+". "+sc.nextLine());
        }
    }
}
