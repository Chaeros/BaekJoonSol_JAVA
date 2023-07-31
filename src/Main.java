import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//127 bronze1 5

public class Main {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int charCount[]=new int[123];

        int max=0;
        int maxVal=0;
        boolean equalCount=false;
        for(int i=0;i<str.length();++i){
            int temp=str.charAt(i);
            if(str.charAt(i)>96) temp-=32;
            ++charCount[temp];
            if(max==charCount[temp]){
                equalCount=true;
            }
            if(max<charCount[temp]) {
                max = charCount[temp];
                equalCount=false;
                maxVal=temp;
            }
        }
        if(equalCount==true) System.out.println("?");
        else System.out.println((char)maxVal);

    }
}