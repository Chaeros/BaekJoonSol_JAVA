import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = 0;

        while(a!=-1){
            a = Integer.parseInt(br.readLine());
            System.out.println(a%1000);
            a%=1000;
            System.out.println(a);
        }

    }
}