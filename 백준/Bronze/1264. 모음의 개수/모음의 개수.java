interface Main{static void main(String[]x){var s=new java.util.Scanner(System.in);while(true){int k=0;String n=s.nextLine().replace("\\s","").toLowerCase();if(n.equals("#"))return;for(char c:n.toCharArray()){if("aeiou".indexOf(c)>=0)k++;}System.out.println(k);}}}