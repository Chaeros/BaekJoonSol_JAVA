package Implementation;

import java.io.*;

public class BOJ2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String result="";

        for(int i=0;i<str.length();++i){
            if(str.charAt(i)>=65 && str.charAt(i)<=90){
                result+=String.valueOf(str.charAt(i)).toLowerCase();
            }
            else{
                result+=String.valueOf(str.charAt(i)).toUpperCase();
            }
        }

        System.out.println(result);
    }
}
