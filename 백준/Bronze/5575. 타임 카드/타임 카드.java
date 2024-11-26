interface Main{static void main(String[]x){
    var c=new java.util.Scanner(System.in);
    while (c.hasNext()) {
        int t = c.nextInt()*3600+c.nextInt()*60+c.nextInt();
        int k = c.nextInt()*3600+c.nextInt()*60+c.nextInt() - t;
        int h = k/3600;
        int m = (k%3600)/60;
        int s = k%60;
        System.out.println(h + " " + m + " " + s);
    }
}
}