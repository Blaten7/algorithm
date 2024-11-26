import java.util.StringTokenizer;

interface Main{
    static void main(String[] args){
        var s = new java.util.Scanner(System.in);
        while(s.hasNextLine()){
            StringTokenizer st = new StringTokenizer(s.nextLine());
            String name = st.nextToken();
            if (name.equals("#")) return;
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (age > 17 || weight >= 80){
                System.out.println(name+" Senior");
            } else {
                System.out.println(name+" Junior");
            }
        }
    }
}