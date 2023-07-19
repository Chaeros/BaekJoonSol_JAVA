package String;

import java.util.Scanner;

public class Problem1259 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            int N = scanner.nextInt();
            if(N==0) break;
            String str= String.valueOf(N);
            int start=0;
            int end=str.length()-1;
            boolean pelindrom=true;
            while(start<end){
                if(str.charAt(start)==str.charAt(end))
                {
                    ++start;
                    --end;
                }
                else{
                    pelindrom=false;
                    break;
                }
            }
            if(pelindrom==true) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
